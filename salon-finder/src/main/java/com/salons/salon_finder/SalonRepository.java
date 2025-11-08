package com.salons.salon_finder;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Ceci est une interface Repository.
 * Elle hérite de JpaRepository, qui vient de Spring Data JPA.
 *
 * Spring va AUTOMATIQUEMENT créer une implémentation
 * pour nous avec toutes les méthodes de base :
 * - save(Salon) : sauvegarder un salon
 * - findById(Long) : trouver un salon par son ID
 * - findAll() : trouver TOUS les salons
 * - deleteById(Long) : supprimer un salon
 * -
 *
 */
public interface SalonRepository extends JpaRepository<Salon, Long> {
    // JpaRepository<TypeDeLentite, TypeDeLID>

    
    // trouver des salons par type :
    List<Salon> findByType(SalonType type);
}