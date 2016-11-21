CREATE TABLE IF NOT EXISTS clients (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
`surname` varchar(100), 
`email` varchar(100), 
`login` varchar(100), 
`password` varchar(100),
`admit` varchar(5),
PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS administrators (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
`surname` varchar(100), 
`email` varchar(100), 
`login` varchar(100), 
`password` varchar(100),
PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS hospitals (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
PRIMARY KEY (`id`) );

CREATE TABLE IF NOT EXISTS departments (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100),
`id_hospital` int,
PRIMARY KEY (`id`)
FOREIGN KEY (`id_hospital`) REFERENCES hospitals(`id`) );

INSERT INTO administrators (name, surname, email, login, password) 
VALUES ("Valeria", "Shpakovskaya", "valeria@gmail.com", "admin", "admin");