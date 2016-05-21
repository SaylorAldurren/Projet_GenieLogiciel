DROP TABLE Auteur cascade constraints purge;
DROP TABLE Livre cascade constraints purge;
DROP TABLE COMPOSITEUR cascade constraints purge;
DROP TABLE CD cascade constraints purge;


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

CREATE TABLE COMPOSITEUR (
	idCompo INTEGER PRIMARY KEY,
	nom VARCHAR2(50),
	prenom VARCHAR2(50),
	ville VARCHAR2(50)
);

CREATE TABLE CD (
	idCD INTEGER PRIMARY KEY,
	titre VARCHAR2(50),
	nbPistes VARCHAR2(50),
	anneeParution INTEGER,
	idCompo INTEGER,
	CONSTRAINT fk_compositeur_id
	FOREIGN KEY (idCompo)
	REFERENCES COMPOSITEUR(idCompo)
);

INSERT INTO AUTEUR VALUES (1,'GOODKIND','Terry','Omaha');
INSERT INTO AUTEUR VALUES (2,'EDDINGS','David','Carson City');
INSERT INTO AUTEUR VALUES (3,'CYMES','Michel','Paris');

INSERT INTO LIVRE VALUES (1,'L epee de verite tome 1','Heroic Fantasy', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 1));
INSERT INTO LIVRE VALUES (2,'La redemption d Althalus', 'Heroic Fantasy', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 1));
INSERT INTO LIVRE VALUES (3,'Hippocrate aux enfers', 'Litterature et Documentation', (SELECT idAuteur FROM AUTEUR WHERE idAuteur = 3));

INSERT INTO COMPOSITEUR VALUES (1,'WILLIAMS','Jeff','Unknown');
INSERT INTO COMPOSITEUR VALUES (2, 'DUNNE', 'Gavin', 'Unknown');

INSERT INTO CD VALUES (1,'LEVEL 5', 30, 2014, (SELECT idCompo FROM COMPOSITEUR WHERE idCompo = 2));
INSERT INTO CD VALUES (2,'METAL UP', 11, 2015, (SELECT idCompo FROM COMPOSITEUR WHERE idCompo = 2));
INSERT INTO CD VALUES (3, 'RWBY Volume 3 Soundtrack', 30, 2016, (SELECT idCompo FROM COMPOSITEUR WHERE idCompo = 1));

