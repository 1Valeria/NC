--CREATE DATABASE cracker CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS clients (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
`surname` varchar(100), 
`email` varchar(100), 
`login` varchar(100), 
`password` varchar(100),
`admit` varchar(5),
PRIMARY KEY (`id`) )ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS doctors (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
`surname` varchar(100), 
`issue` varchar(100), 
`education` varchar(100), 
`email` varchar(100), 
`login` varchar(100), 
`password` varchar(100),
`admit` varchar(5),
`id_department` int,
PRIMARY KEY (`id`),
FOREIGN KEY (`id_department`) REFERENCES departments(`id`) )ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS administrators (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
`surname` varchar(100), 
`email` varchar(100), 
`login` varchar(100), 
`password` varchar(100),
PRIMARY KEY (`id`) )ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS hospitals (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100), 
PRIMARY KEY (`id`) )ENGINE=InnoDB CHARACTER SET=UTF8;

CREATE TABLE IF NOT EXISTS departments (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(100),
`id_hospital` int,
PRIMARY KEY (`id`),
FOREIGN KEY (`id_hospital`) REFERENCES hospitals(`id`) )ENGINE=InnoDB CHARACTER SET=UTF8;



INSERT INTO administrators (name, surname, email, login, password) 
VALUES ("Valeria", "Shpakovskaya", "valeria@gmail.com", "admin", "admin");