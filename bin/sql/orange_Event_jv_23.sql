drop DATABASE if exists orange_Event_jv_23;

create DATABASE orange_Event_jv_23 ;

use orange_Event_jv_23;

create Table
    client(
        idclient int not null auto_increment,
        nom varchar(50),
        prenom varchar(50),
        adresse varchar(50),
        email varchar(50),
        PRIMARY key(idclient)
    );

create Table
    technicien(
        idtechnicien int not null auto_increment,
        nom varchar(50),
        prenom varchar(50),
        qualification varchar(50),
        email varchar(50),
        mdp varchar(50),
        PRIMARY key(idtechnicien)
    );

create Table
    intervention (
        idinter int not null auto_increment,
        materiel VARCHAR(50),
        panne VARCHAR(50),
        dateinter date,
        prix float,
        idclient int NOT NULL,
        idtechnicien int NOT NULL,
        PRIMARY key(idinter),
        FOREIGN key(idclient) REFERENCES client(idclient),
        FOREIGN key(idtechnicien) REFERENCES technicien(idtechnicien)
    );

INSERT INTO technicien
VALUES (
        null,
        "Thamila",
        "Miguel",
        "technicien",
        "a@gmail.com",
        "123"
    );