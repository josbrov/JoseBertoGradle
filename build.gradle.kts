plugins {
    id("java")
    id ("application")
}

group = "com.joseberto.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")

}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass.set("josebertogradle.Main")
}

tasks.register<Exec>("ollamaVersion"){
    commandLine("bash", "-lc","ollama --version");
}

tasks.register<Exec>("ollamaPs"){
    commandLine("bash", "-lc","ollama ps");
}

tasks.register("llmInfo"){
    dependsOn("ollamaVersion","ollamaPs")
    doLast{
        println("DEMO FINALIZADA")
        }
    }

//COMPROBAR SI WINDOWS O LINUX
val OS=System.getProperty("os.name");

tasks.register("verSO"){
    doLast {
        println(OS)  }
}


tasks.register<Exec>("ollamaVersionSO"){
    if (OS.startsWith("L"))
    commandLine("bash", "-lc","ollama --version");
    else if(OS.startsWith("W")){
        commandLine("cmd", "/c","ollama --version");
    }else{
        doLast{
            println("NO TENGO INSTRUCCIONES PARA ESTE S.O")
        }
    }
}


tasks.register<Exec>("ollamaPsSO"){
    if (OS.startsWith("L"))
        commandLine("bash", "-lc","ollama ps");

    else if(OS.startsWith("W")){
        commandLine("cmd", "/c","ollama ps");
    }else{
        doLast{
            println("NO TENGO INSTRUCCIONES PARA ESTE S.O")
        }
    }
}



