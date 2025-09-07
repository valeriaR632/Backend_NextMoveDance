 SHOW TABLES;
 SELECT * FROM clases;
 SELECT * FROM inscripcion;
 SELECT * FROM maestros;
 SELECT * FROM pago;
 SELECT * FROM usuario;
 -- Registro de 5 Usuarios
 INSERT INTO usuario
 VALUES(null,"Valeria","Rojas","5540240228","valeriarojas@gmail.com","2025-08-01");
  INSERT INTO usuario
 VALUES(null,"Maria","Moreno","5502781034","mariamoreno@gmail.com","2025-08-12"),
 (null,"Kassandra","Negrete","5522648900","kassandranegrete@gmail.com","2025-08-16"),
 (null,"Lilia","Cardenas","5590765432","liliacardenas@gmail.com","2025-08-16"),
 (null,"Sofia","Meza","1234567865","sofiameza@gmail.com","2025-09-01");
 -- Registro de 5 maestros
 
 ALTER TABLE Maestros
ADD COLUMN turno VARCHAR (100) NOT NULL; -- Se inserto la columna Turno

 INSERT INTO maestros
 VALUES(null, "Pablo","López", "326472746", "@pabloL", "Vespertino"), 
(null, "Indigo","Valenzuela", "6555384736", "@indigoV", "Fin de semana"), 
(null, "Zhevia","Kings", "8827462535", "@zheviakings", "Vespertino"), 
(null, "Kardan","Muñoz", "9987736453", "@kardanMuñoz", "Vespertino"),
(null, "Kennybyaa","A", "8765463746", "@kennybyaa", "Vespertino");

-- Registro de 5 clases
INSERT INTO clases
VALUES (null, "Hip-Hop","15 años en adelante" ,"lunes de 18:00 a 19:30 hrs", 1),
(null,"Hip-Hop","15 años en adelante" ,"Sábado y domingo de 11:00 a 12:15 hrs.", 2),
(null, "Heels", "15 años en adelante" ,"Jueves de 19:30 a 21:00 hrs.", 3),
(null, "Heels","15 años en adelante" ,"Sábado de 12:15 a 13:30 hrs.", 3), 
(null,"Jazz","15 años en adelante" , "Jueves de 18:00 a 19:00 hrs.", 4);

-- Registro de pagos
INSERT INTO pago
VALUES (null, 700, "anual","2025-08-01" ),
(null, 130, "suelta","2025-08-12" ),
(null, 700, "anual", "2025-08-16"),
(null, 130, "suelta", "2025-08-16"),
(null, 700, "anual","2025-09-01" );

-- Registro de 5 inscripciones
INSERT INTO inscripcion
VALUES(null,"2025-08-01",5,1,1 ),
(null, "2025-08-12",1,2,2 ),
(null,"2025-08-16",4,3,3),
(null, "2025-08-16",2,4,4),
(null, "2025-09-01",3,5,5 );



