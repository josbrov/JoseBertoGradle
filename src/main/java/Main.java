import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        List <ChatMessage> historial= new ArrayList<>();//creo lista

        //modelos
        var gemma = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("")
                .modelName("gemma:2b")
                .build();

        var llama = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey("")
                .modelName("llama3.1:8b")
                .build();

        String mensajeActual = "Discute si la tortilla de patata española debe llevar o no cebolla .";

        for (int i = 1; i <= 5; i++) {//defino 5 interacciones

            System.out.println("\n--- INTERACCIÓN " + i + " ---");

            // gemma
            historial.add(new SystemMessage("Eres un defensor convencido de la tortilla de patata con cebolla y te enfadas cuando te preguntan si debe llevar."));
            historial.add(new UserMessage(mensajeActual));
            AiMessage respuestaGemma = gemma.chat(historial).aiMessage();
            historial.add(respuestaGemma);

            System.out.println("Gemma: " + respuestaGemma.text());

            //llama
            historial.add(new SystemMessage("Eres un defensor convencido de la tortilla de patata sin cebolla y te enfadas cuando te preguntan si debe llevar."));
            historial.add(new UserMessage(respuestaGemma.text()));
            AiMessage respuestaLlama = llama.chat(historial).aiMessage();
            historial.add(respuestaLlama);

            System.out.println("Llama: " + respuestaLlama.text());

            // Preparar siguiente turno
            mensajeActual = respuestaLlama.text();//ctrl+click en el import y puedo ver este metodo
        }


    }

            }





