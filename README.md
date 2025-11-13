Salon Finder - Application Web de Recherche de Salons

Salon Finder est une application web full-stack permettant de rechercher des salons de coiffure à proximité. L'application utilise l'API Google Maps pour afficher une carte interactive et l'API Google Places pour récupérer des données en temps réel sur les salons (nom, adresse, note, statut).

Le backend est construit avec Java Spring Boot et le tout est déployé dans un environnement Docker multi-conteneurs (une application app et une base de données db PostgreSQL).

Aperçu
<img width="1905" height="930" alt="image" src="https://github.com/user-attachments/assets/1f861d3c-5768-4a4d-a639-bc8f3ad53e92" />


Fonctionnalités

Carte Interactive : Affiche une carte Google Maps centrée sur Paris (par défaut).

Recherche en Temps Réel : Utilise l'API Google Places (Place.searchByText) pour trouver les salons de coiffure à proximité de la zone visible de la carte.

Recherche par Mots-clés : Permet à l'utilisateur d'affiner la recherche avec des mots-clés (ex: "barbier", "lissage").

Liste des Résultats : Affiche les salons trouvés dans une liste détaillée (nom, adresse, note, statut d'ouverture).

Marqueurs Personnalisés : Affiche des icônes de ciseaux (✂️) sur la carte pour chaque salon.

Déploiement Conteneurisé : L'ensemble de l'application (Backend Java + Base de données PostgreSQL) est géré par docker-compose.

Architecture

Le projet suit une architecture client-serveur, entièrement conteneurisée :

Frontend (Client) : Une application légère (HTML, CSS Bootstrap, JavaScript) servie statiquement par le backend. Elle gère l'affichage de la carte et les appels directs à l'API Google Places.

Backend (Serveur) : Une application Java 21 / Spring Boot 3 qui sert le frontend.

Base de Données : Un service PostgreSQL (postgres:15) s'exécutant dans son propre conteneur Docker. (Note : la BDD est utilisée par Spring, mais les données des salons proviennent de Google).

Déploiement : Un fichier docker-compose.yml orchestre le lancement des deux services (app et db), les reliant via un réseau Docker privé.

Technologies utilisées

Backend :

Java (JDK 21)

Spring Boot

Spring Web

Spring Data JPA

Maven

Frontend :

HTML5

CSS3 / Bootstrap 5

JavaScript (ES6+)

API & Services :

Google Maps JavaScript API

Google Places API (Nouvelle version - Place.searchByText)

Base de Données :

PostgreSQL 15

Déploiement :

Docker

Docker Compose

Installation et Lancement Local

Suivez ces étapes pour lancer le projet sur votre machine.

1. Prérequis

Docker Desktop installé et lancé.

Java 21 (ou +)

Apache Maven

Un compte Google Cloud

2. Configuration de Google Maps

C'est l'étape la plus importante.

Allez sur la Google Cloud Console.

Créez un nouveau projet.

Créez une Clé API.

Activez les 3 API suivantes pour votre projet :

Maps JavaScript API

Places API

(Vous devrez peut-être aussi activer MapId si vous n'utilisez pas DEMO_MAP_ID)

Activez la facturation (Billing) pour votre projet. L'API Places (New) est un service "premium" et ne fonctionnera pas sans (même avec le quota gratuit).

Sécurisez votre clé API :

Allez dans "Identifiants" -> Cliquez sur votre clé.

Dans "Restrictions d'application", cochez "Sites Web".

Dans "Restrictions liées aux sites Web", cliquez sur "AJOUTER UN RÈGLE" et entrez : http://localhost:8080/*

Enregistrez.

3. Lancement de l'application

Clonez ce dépôt :

git clone [(https://github.com/brayann-Ouandji/salon-finder.git)]


Ouvrez le fichier src/main/resources/static/index.html.

Remplacez la ligne de la clé par la nouvelle clé API sécurisée que vous venez de créer.




Construisez l'application avec Maven (cela inclura votre index.html mis à jour dans le .jar) :

mvnw package -DskipTests


(Utilisez mvn si mvnw n'est pas disponible)

Lancez l'ensemble de l'architecture avec Docker Compose. L'option --build force Docker à reconstruire l'image app avec votre nouveau .jar.

docker-compose up --build


Ouvrez votre navigateur et allez sur :
http://localhost:8080/

L'application est maintenant en ligne ! Zoomez sur une ville pour voir les salons de coiffure apparaître.
