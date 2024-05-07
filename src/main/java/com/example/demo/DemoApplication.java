package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Método combinado que muestra el formulario y el mensaje de saludo
    @GetMapping("/")
    public String hello(@RequestParam(value = "name", required = false) String name) {
        // Determinar el nombre a mostrar
        String displayName = name != null ? name : "World";
        
        // Construir la respuesta HTML
        return "<html>" +
               "<head>" +
               "<style>" +
               "body { height: 100vh; margin: 0; display: flex; flex-direction: column; align-items: center; justify-content: center; font-family: Arial, sans-serif; }" +
               "form { display: flex; flex-direction: column; align-items: center; gap: 10px; }" +
               "input[type='text'], button { padding: 15px; font-size: 16px; }" +
               "</style>" +
               "</head>" +
               "<body>" +
               // Saludo personalizado
               "<h1>Hola " + displayName + "!</h1>" +
               // Formulario para cambiar el nombre
               "<form action='/' method='get'>" + // Usando método GET para simplificar
               "<input type='text' name='name' placeholder='Introduce Nombre'/>" +
               "<button type='submit'>OK</button>" +
               "</form>" +
               "</body>" +
               "</html>";
    }
}
