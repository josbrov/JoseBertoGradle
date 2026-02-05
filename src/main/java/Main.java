import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.openai.OpenAiChatModel;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        List <ChatMessage> historial= new ArrayList<>();

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
            for(int i=0;i<10;i++){//declaro 10 interacciones




            }
    }



}
