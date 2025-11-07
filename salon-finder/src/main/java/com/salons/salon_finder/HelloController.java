package com.salons.salon_finder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    /**
     * @GetMapping("/hello") indique à Spring que toute requête HTTP GET
     * sur l'URL "/hello" doit exécuter cette méthode.
     * * @return Une simple chaîne de caractères.
     */
    @GetMapping("/hello")
    public String hello() {
        return " Le serveur Spring Boot fonctionne !";
    }
}
