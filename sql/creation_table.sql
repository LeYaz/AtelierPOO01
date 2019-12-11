 --  CREATE DATABASE Bdd_Garage;

START TRANSACTION;
--  Table Employee

CREATE TABLE employee( 
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL

);


--  Table profil
CREATE TABLE profil(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    statut VARCHAR(50) NOT NULL
);

--  Table profil_employee
CREATE TABLE profil_employee(
    id_employee INTEGER,
    id_profil INTEGER,
    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_profil) REFERENCES profil(id)
);

--  Table type_client
CREATE TABLE type_client(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(50) NOT NULL
);

-- Table Client
CREATE TABLE client(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_type_client INTEGER,
    id_employee INTEGER,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    adresse VARCHAR(50) NOT NULL,
    code_postal VARCHAR(50) NOT NULL,
    ville VARCHAR(50) NOT NULL,
    telephone VARCHAR(50) NOT NULL,
    mobile VARCHAR(50) NOT NULL,
    FOREIGN KEY(id_type_client) REFERENCES type_client(id),
    FOREIGN KEY(id_employee) REFERENCES employee(id)
);
--  Table fiche
CREATE TABLE fiche(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_client INTEGER,
    etat BIT DEFAULT 0,
    Date_creation DATE,
    Date_cloture DATE DEFAULT NULL,
    FOREIGN KEY(id_client) REFERENCES client(id)
);

--  Table facture_fiche
CREATE TABLE facture_fiche(
   id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   id_fiche INTEGER, 
   prixHT FLOAT,
   prixTTC FLOAT,
   FOREIGN KEY(id_fiche) REFERENCES fiche(id) 
);
--  table priorite
CREATE TABLE priorite(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    libelle VARCHAR(50) NOT NULL
);
--  table taches
CREATE TABLE tache(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    commentaire varchar(200),
    id_employee INTEGER,
    id_fiche INTEGER,
    id_priorite INTEGER,
    etat BIT DEFAULT 0,
    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_fiche) REFERENCES fiche(id),
    FOREIGN KEY(id_priorite) REFERENCES priorite(id)
);

--  table pieces
CREATE TABLE pieces(
   id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   quantite INTEGER,
   date_saisie DATE 
);
-- table utilisation pieces
CREATE TABLE utilisation_piece(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_piece INTEGER,
    id_tache INTEGER,
    quantite INTEGER,
    FOREIGN KEY(id_piece) REFERENCES pieces(id),
    FOREIGN KEY(id_tache) REFERENCES tache(id)
);

--  table commande pieces
CREATE TABLE commande_piece(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_employee INTEGER,
    id_piece INTEGER,
    quantite INTEGER,
    date_creation DATE,
    date_cloture DATE DEFAULT NULL,
    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_piece) REFERENCES pieces(id)
);
--  table devis
CREATE TABLE devis(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_client INTEGER,
    id_employee INTEGER,
    date_creation DATE,
    FOREIGN KEY(id_client) REFERENCES client(id),
    FOREIGN KEY(id_employee) REFERENCES employee(id)
);



--  table fature devis
CREATE TABLE facture_devis(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_devis INTEGER,
    prixHT FLOAT,
    prixTTC FLOAT,
    date_creation DATE,
    FOREIGN KEY(id_devis) REFERENCES devis(id)
);
--  table commande vehicule
CREATE TABLE commande_vehicule(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_devis INTEGER,
    etat BIT DEFAULT 0,
    date_creation DATE,
    date_cloture DATE DEFAULT NULL,
    FOREIGN KEY(id_devis) REFERENCES devis(id)

);

--  table vehicule
CREATE TABLE vehicule(
    id INTEGER(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    modele VARCHAR(50) NOT NULL,
    quantite INTEGER,
    prix FLOAT,
    date_creation DATE 
);
--  table vente vehicule
CREATE TABLE vente_vehicule(
    id_vehicule INTEGER,
    id_devis INTEGER,
    quantite INTEGER,
    FOREIGN KEY(id_vehicule) REFERENCES vehicule(id),
    FOREIGN key(id_devis) REFERENCES devis(id)
);

COMMIT;