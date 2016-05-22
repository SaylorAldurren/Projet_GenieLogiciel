DROP TABLE Auteur cascade constraints purge;
DROP TABLE Livre cascade constraints purge;


CREATE TABLE AUTEUR (
	idAuteur INTEGER PRIMARY KEY,
	nom VARCHAR2(50),
	prenom VARCHAR2(50),
	ville VARCHAR2(50)
);

CREATE TABLE LIVRE (
	idLivre INTEGER PRIMARY KEY,
	titre VARCHAR2(50),
	genre VARCHAR2(50),
	idAuteur INTEGER,
	CONSTRAINT fk_auteur_id
	FOREIGN KEY (idAuteur)
	REFERENCES AUTEUR(idAuteur)
);

INSERT INTO AUTEUR VALUES (1,'GOODKIND','Terry','Omaha');
INSERT INTO AUTEUR VALUES (2,'EDDINGS','David','Carson City');
INSERT INTO AUTEUR VALUES (3,'CYMES','Michel','Paris');

INSERT INTO LIVRE VALUES (1,'L epee de verite tome 1','Heroic Fantasy', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 1));
INSERT INTO LIVRE VALUES (2,'La redemption d Althalus', 'Heroic Fantasy', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 1));
INSERT INTO LIVRE VALUES (3,'Hippocrate aux enfers', 'Litterature et Documentation', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 3));

