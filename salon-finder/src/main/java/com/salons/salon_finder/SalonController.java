package com.salons.salon_finder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    @Autowired
    private SalonRepository salonRepository;

    /**
     * MÉTHODE MISE À JOUR :
     * Elle accepte maintenant un paramètre optionnel "type"
     */
    @GetMapping
    public List<Salon> getAllSalons(@RequestParam(required = false) SalonType type) {
        if (type != null) {
            // Si un type est fourni (ex: /api/salons?type=HOMME)
            // On utilise notre nouvelle méthode de repository
            return salonRepository.findByType(type);
        } else {
            // Si aucun type n'est fourni, on retourne tout
            return salonRepository.findAll();
        }
    }

    @PostMapping
    public Salon createSalon(@RequestBody Salon salon) {
        return salonRepository.save(salon);
    }
}