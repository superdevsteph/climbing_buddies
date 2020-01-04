
DROP DATABASE IF EXISTS climbing_buddy;
CREATE DATABASE climbing_buddy;
USE climbing_buddy;
show DATABASES;


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
	topo_publication DATETIME
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_topo (topo_id, topo_nom, topo_region, topo_nbSites, topo_nbSecteurs, topo_nbVoies, topo_disponible, topo_description, topo_user_fk_id) VALUES ('1', 'Topo1', 'bla', '4', '4564', '4564', '0', 'premier topo', '1');
INSERT INTO tb_topo (topo_id, topo_nom, topo_region, topo_nbSites, topo_nbSecteurs, topo_nbVoies, topo_disponible, topo_description, topo_user_fk_id) VALUES ('2', 'Topo2', 'bla', '4', '4564', '4564', '0', 'deuxieme topo', '2');


CREATE TABLE tb_user(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	user_username VARCHAR(40) NOT NULL,
	user_name VARCHAR(15),
	user_firstname VARCHAR(15),
	user_birthdate DATE,
	user_email VARCHAR(30),
	user_password VARCHAR(60) NOT NULL,
	user_cotation VARCHAR(15),
	adresse_adress1 VARCHAR(30),
	adresse_adress2 VARCHAR(30),
	adresse_postalCode VARCHAR(10),
	adresse_city VARCHAR(20),
	adresse_country VARCHAR(20)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


INSERT INTO tb_user (user_id, user_username, user_email, user_password, user_cotation) 
VALUES (1, 'stephmehraik', 'stephanie.mehraik@gmail.com', 'password', 10);
INSERT INTO tb_user (user_id, user_username, user_email, user_password, user_cotation) 
VALUES (2, 'steph', 'stephanie.mehraik@gmail.com', 'password', 40);
INSERT INTO tb_user (user_id, user_username,user_email, user_password, user_cotation) 
VALUES (3, 'bond', 'stephanie.mehraik@gmail.com', '007', 50);
INSERT INTO tb_user (user_id, user_username, user_email, user_password, user_cotation) 
VALUES (4, 'bla', 'stephanie.mehraik@gmail.com', 'bla', 12);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

LOCK TABLES role WRITE;
INSERT INTO role VALUES (1,'ROLE_USER');
INSERT INTO role VALUES (2,'ROLE_ADMIN');
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  KEY fk_user_role_roleid_idx (role_id),
  CONSTRAINT fk_user_role_roleid FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_user_role_userid FOREIGN KEY (user_id) REFERENCES tb_user (user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





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
