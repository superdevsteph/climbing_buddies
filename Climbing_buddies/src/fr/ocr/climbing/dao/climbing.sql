
DROP DATABASE IF EXISTS climbing_buddy;
CREATE DATABASE climbing_buddy;
USE climbing_buddy;
show DATABASES;




CREATE TABLE tb_user(
	user_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	user_login VARCHAR(40) NOT NULL,
	user_nom VARCHAR(15) NOT NULL,
	user_prenom VARCHAR(15) NOT NULL,
	user_dateNaissance DATE,
	user_email VARCHAR(30) NOT NULL,
	user_password VARCHAR(60) NOT NULL,
	user_cotation VARCHAR(15),
	adresse_adresse1 VARCHAR(30),
	adresse_adresse2 VARCHAR(30),
	adresse_codePostal VARCHAR(10),
	adresse_ville VARCHAR(20),
	adresse_pays VARCHAR(20)
)ENGINE = InnoDB;


INSERT INTO tb_user (user_id, user_login, user_nom, user_prenom, user_email, user_password, user_cotation) 
VALUES (1, 'stephmehraik', 'Mehraik', 'Stéphanie', 'stephanie.mehraik@gmail.com', 'password', 10);
INSERT INTO tb_user (user_id, user_login, user_nom, user_prenom, user_email, user_password, user_cotation) 
VALUES (2, 'steph', 'Mehraik', 'Stéphanie', 'stephanie.mehraik@gmail.com', 'password', 40);
INSERT INTO tb_user (user_id, user_login, user_nom, user_prenom, user_email, user_password, user_cotation) 
VALUES (3, 'bond', 'Mehraik', 'Stéphanie', 'stephanie.mehraik@gmail.com', '007', 50);
INSERT INTO tb_user (user_id, user_login, user_nom, user_prenom, user_email, user_password, user_cotation) 
VALUES (4, 'bla', 'Mehraik', 'Stéphanie', 'stephanie.mehraik@gmail.com', 'bla', 12);



CREATE TABLE tb_admin (
	user_id				int(4)		NOT NULL REFERENCES tb_user(user_id),
	Rights				varchar(10) NOT NULL
) ENGINE = InnoDB;

INSERT INTO tb_admin VALUES ( 1, "-RWX------" );
INSERT INTO tb_admin VALUES ( 5, "-RWX------" );



CREATE TABLE tb_topo (
  topo_id INT(4) PRIMARY KEY AUTO_INCREMENT,
  topo_nom VARCHAR(15) NOT NULL,
	topo_region VARCHAR(30),
	topo_nbSites INTEGER,
	topo_nbSecteurs INTEGER,
	topo_nbVoies INTEGER,
	topo_disponible BOOLEAN,
	topo_description TEXT NOT NULL,
	topo_user_fk_id INTEGER,
	topo_image VARCHAR(100),
	topo_dateCreation TIMESTAMP,
	topo_lastUpdate TIMESTAMP,
	topo_publication boolean
);

INSERT INTO `climbing_buddy`.`tb_topo` (`topo_id`, `topo_nom`, `topo_region`, `topo_nbSites`, `topo_nbSecteurs`, `topo_nbVoies`, `topo_disponible`, `topo_description`, `topo_user_fk_id`) VALUES ('1', 'Topo1', 'bla', '4', '4564', '4564', '0', 'premier topo', '1');
INSERT INTO `climbing_buddy`.`tb_topo` (`topo_id`, `topo_nom`, `topo_region`, `topo_nbSites`, `topo_nbSecteurs`, `topo_nbVoies`, `topo_disponible`, `topo_description`, `topo_user_fk_id`) VALUES ('2', 'Topo2', 'bla', '4', '4564', '4564', '0', 'deuxieme topo', '2');



CREATE TABLE tb_site (
  site_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	site_nom VARCHAR(20) NOT NULL,
	site_description TEXT,
	site_user_fk_id INTEGER,
	site_dateCreation TIMESTAMP,
	site_lastUpdate TIMESTAMP,
	site_publication boolean,
	site_image VARCHAR(100),
	site_region VARCHAR(50)
);

CREATE TABLE tb_secteur (
	secteur_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	secteur_nom VARCHAR(20) NOT NULL,
	secteur_description TEXT,
	secteur_user_fk_id INTEGER,
	secteur_dateCreation TIMESTAMP,
	secteur_lastUpdate TIMESTAMP,
	secteur_publication boolean,
	secteur_image VARCHAR(100),
	secteur_departement VARCHAR(50)
);
   
CREATE TABLE tb_voie (
	voie_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	voie_nom VARCHAR(20) NOT NULL,
	voie_description TEXT,
	voie_user_fk_id INTEGER,
	voie_dateCreation TIMESTAMP,
	voie_lastUpdate TIMESTAMP,
	voie_publication boolean,
	voie_image VARCHAR(100),
	voie_hauteurVoie NUMERIC(10,1),
	voie_cotation VARCHAR(15),
	voie_nbPoints INTEGER,
	voie_equipee BOOLEAN
);

CREATE TABLE tb_longueur (
	longueur_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	longueur_nom VARCHAR(20) NOT NULL,
	longueur_description TEXT,
	longueur_user_fk_id INTEGER,
	longueur_dateCreation TIMESTAMP,
	longueur_lastUpdate TIMESTAMP,
	longueur_publication boolean,
	longueur_image VARCHAR(100),
	longueur_relai NUMERIC(10,1),
	longueur_voie_fk_id INTEGER,
	longueur_cotation VARCHAR(15)
);

CREATE TABLE tb_location_topo(
	loc_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	loc_dateDebut TIMESTAMP,
	loc_dateFin TIMESTAMP,
	loc_topoProprioUser_fk_id INTEGER,
	loc_topoLoueurUser_fk_id INTEGER,
	loc_topo_fk_id INTEGER,
	loc_status VARCHAR(15)
);

CREATE TABLE tb_commentaire (
	com_id  INT(4) PRIMARY KEY AUTO_INCREMENT,
	com_dateCreation TIMESTAMP,
	com_commentaire TEXT,
	com_user_fk_id INTEGER,
	com_table_fk_id INTEGER,
	com_target_table VARCHAR(20)
);

CREATE TABLE tb_site_secteur_asso (
	site_secteur_asso_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	site_fk_id INTEGER,
	secteur_fk_id INTEGER
);

CREATE TABLE tb_secteur_voie_asso (
	secteur_voie_asso_id INT(4) PRIMARY KEY AUTO_INCREMENT,
	secteur_fk_id INTEGER,
	voie_fk_id INTEGER
);

grant all on climbing_buddy.* to 'climbing_buddy'@'localhost';
SHOW TABLES;
