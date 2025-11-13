# Étape 1 : Utiliser une image de base avec Java 17
FROM eclipse-temurin:21-jdk-jammy

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier .jar (construit par Maven) dans le conteneur
# (Nous devrons d'abord construire ce .jar)
COPY target/*.jar app.jar

# Exposer le port sur lequel Spring Boot tourne
EXPOSE 8080

# La commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]