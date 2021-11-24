drop table is exists tests;

create table tests(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL
)

insert into tests(nombre) values ('Prueba de test realizada');