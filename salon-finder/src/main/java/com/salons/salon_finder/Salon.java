package com.salons.salon_finder;

// Importations nécessaires pour les annotations JPA
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * Chaque instance de cette classe représentera une ligne dans la table "salon"
 * de notre base de données.
 */
@Entity // la classe est une entité à persister
public class Salon {

    @Id //  clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // L'ID sera généré par la BDD
    private Long id;

    private String nom;
    private String adresse;

    //  Google Maps
    private Double latitude;
    private Double longitude;

    //  stock l'Enum en chaîne de caractères
    @Enumerated(EnumType.STRING)
    private SalonType type;

    
    public Salon() {
    }

    // Un constructeur pour nos tests
    public Salon(String nom, String adresse, Double latitude, Double longitude, SalonType type) {
        this.nom = nom;
        this.adresse = adresse;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public SalonType getType() {
        return type;
    }

    public void setType(SalonType type) {
        this.type = type;
    }
}