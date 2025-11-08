-- Ce fichier sera exécuté automatiquement par Spring Boot
-- pour remplir la base de données H2 en mémoire.

-- La table s'appelle "salon" (Spring le devine depuis le nom de la classe @Entity "Salon")
-- On n'insère pas d_ID, car il est auto-généré.

INSERT INTO salon (nom, adresse, latitude, longitude, type)
VALUES
('Barbier de la Cité', '1 Rue de la Paix, 75001 Paris', 48.8690, 2.3306, 'HOMME');

INSERT INTO salon (nom, adresse, latitude, longitude, type)
VALUES
('Coiffure Elle', '10 Avenue des Champs-Élysées, 75008 Paris', 48.8695, 2.3080, 'FEMME');

INSERT INTO salon (nom, adresse, latitude, longitude, type)
VALUES
('Style & Ciseaux', '50 Boulevard Voltaire, 75011 Paris', 48.8596, 2.3811, 'MIXTE');

INSERT INTO salon (nom, adresse, latitude, longitude, type)
VALUES
('Le Look Tendance', '22 Rue Montorgueil, 75002 Paris', 48.8653, 2.3484, 'MIXTE');