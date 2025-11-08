package com.salons.salon_finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Le contrôleur REST pour gérer les Salons.
 * @RestController combine @Controller et @ResponseBody,
 * indiquant que les réponses seront directement en JSON.
 *
 * @RequestMapping("/api/salons")
 * Toutes les méthodes de cette classe auront des URLs qui
 * commencent par "/api/salons".
 */
@RestController
@RequestMapping("/api/salons")
public class SalonController {

    // @Autowired dit à Spring d'injecter (fournir) automatiquement
    // injection de dépendances.
    @Autowired
    private SalonRepository salonRepository;

    /**
     * Endpoint pour lister tous les salons.
     * URL : GET http://localhost:8080/api/salons
     *
     * @return Une liste de tous les salons en JSON.
     */
    @GetMapping
    public List<Salon> listerTousLesSalons() {
        //  existe déjà ! Grâce à JpaRepository
        return salonRepository.findAll();
    }

    /**
     * Endpoint pour créer un nouveau salon.
     * URL : POST http://localhost:8080/api/salons
     *
     * @param salon Le nouveau salon à créer, envoyé en JSON dans le corps
     * de la requête.
     * @return Le salon sauvegardé (avec son nouvel ID).
     */
    @PostMapping
    public Salon creerSalon(@RequestBody Salon salon) {
        // @RequestBody dit à Spring de convertir le JSON reçu en objet Salon.
        return salonRepository.save(salon);
    }

}