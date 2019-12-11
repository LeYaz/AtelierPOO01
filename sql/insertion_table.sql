SET AUTOCOMMIT = 0;
START TRANSACTION;

--  Table Employee

INSERT INTO Employee
(nom, prenom) VALUES ('Jean','Jean'),
('Monsieur','test');

--  Table profil

INSERT INTO profil
(statut) VALUES ('mecanicien'),
('Chef d atelier'),
('Maganisier'),
('commercial');


--  Table profil_employee
INSERT INTO profil_employee
(id_employee, id_profil) VALUES (1,1),
(1,2),
(2,3);


--  Table type_client

INSERT INTO type_client
(libelle) VALUES ('Client Atelier'),
('Client vente');

-- Table Client

INSERT INTO client
(id_type_client, id_employee, nom, prenom, adresse, code_postal,ville,telephone,mobile)
VALUES (1,1,'Monsieur','reparation', 'ici','test','lyon', '0606', '3949'),
 (2,1,'Monsieur','achat', 'labas','re','lyon', '3919', '3949');

--  Table fiche
  
INSERT INTO fiche (id_client, date_creation)
VALUES (1,'2019-12-11');

--  Table facture_fiche

INSERT INTO facture_fiche(id_fiche)
VALUES(1);

--  table priorite

INSERT INTO priorite(libelle)
VALUES('non defini'),
('Trés urgent'),
('urgent'),
('normal'),
('Non prioritaire');

--  table taches

INSERT INTO tache(id_employee, id_fiche, id_priorite, commentaire)
VALUES (1,1,3,'changer les pneu du vehicule');

--  table pieces

INSERT INTO pieces(libelle, quantite, date_saisie)
VALUES ('pneus', 20, '2019-12-11');

-- table utilisation pieces

INSERT INTO utilisation_piece(id_piece, id_tache, quantite)
VALUES(1,1,4);

--  table commande pieces

INSERT INTO commande_piece(id_employee, id_piece, quantite, date_creation)
VALUES (1,1, 20, '2018-02-09');

--  table devis


INSERT INTO devis(id_client, id_employee, date_creation)
VALUES(1,1,'2019-12-10');

--  table fature devis

INSERT INTO facture_devis(id_devis,prixHT,prixTTC,date_creation)
VALUES (1,150,180,'2019-12-11');

--  table commande vehicule

INSERT INTO commande_vehicule(id_devis,date_creation)
VALUES(1,'2019-12-10');

--  table vehicule


INSERT INTO vehicule(modele,quantite,prix,date_creation)
VALUES ('renault kangoo',1, 30000, '2019-11-29');

--  table vente vehicule

INSERT INTO vente_vehicule(id_vehicule,id_devis,quantite)
VALUES(1,1,1);

COMMIT;