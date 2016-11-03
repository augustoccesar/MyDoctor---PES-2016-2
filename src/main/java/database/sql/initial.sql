CREATE DATABASE IF NOT EXISTS mydoctor;
USE mydoctor;

CREATE TABLE IF NOT EXISTS users (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL UNIQUE ,
  encrypted_password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS persons (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL ,
  name VARCHAR(30) NOT NULL ,
  birth_date DATE NOT NULL ,
  gender VARCHAR(20) NOT NULL ,
  FOREIGN KEY (user_id) REFERENCES users(id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS phone_numbers (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  person_id INT NOT NULL ,
  ddi INT NOT NULL DEFAULT 55 ,
  ddd INT NOT NULL ,
  number INT NOT NULL ,
  type VARCHAR(50) NOT NULL,
  FOREIGN KEY (person_id) REFERENCES persons(id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS expertise (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL
);
INSERT INTO expertise (name) VALUES ('Acupuntura');
INSERT INTO expertise (name) VALUES ('Alergia e Imulogia');
INSERT INTO expertise (name) VALUES ('Anestesiologia');
INSERT INTO expertise (name) VALUES ('Angiologia');
INSERT INTO expertise (name) VALUES ('Cardiologia');

CREATE TABLE IF NOT EXISTS doctors (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  person_id INT NOT NULL ,
  board_number VARCHAR(100) NOT NULL ,
  FOREIGN KEY (person_id) REFERENCES persons(id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS doctor_expertise (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  doctor_id INT NOT NULL,
  expertise_id INT NOT NULL,
  FOREIGN KEY (doctor_id) REFERENCES doctors(id) ON DELETE NO ACTION ON UPDATE CASCADE,
  FOREIGN KEY (expertise_id) REFERENCES expertise(id) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS patients (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  person_id INT NOT NULL ,
  FOREIGN KEY (person_id) REFERENCES persons(id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS health_plan_providers (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS patient_health_plans (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  patient_id INT NOT NULL ,
  health_plan_provider_id INT NOT NULL,
  name VARCHAR(100) NOT NULL ,
  number VARCHAR(100) NOT NULL ,
  start_date DATE NOT NULL ,
  end_date DATE,
  FOREIGN KEY (patient_id) REFERENCES patients(id) ON UPDATE CASCADE ON DELETE NO ACTION,
  FOREIGN KEY (health_plan_provider_id) REFERENCES health_plan_providers(id) ON UPDATE CASCADE ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS point_of_care_type (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
);
INSERT INTO point_of_care_type (name) VALUES ('Privado');
INSERT INTO point_of_care_type (name) VALUES ('Público');
INSERT INTO point_of_care_type (name) VALUES ('Conveniado');


CREATE TABLE IF NOT EXISTS point_of_care (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  phone_ddd INT,
  phone_number INT,
  point_of_care_type_id INT NOT NULL,
  street VARCHAR(255),
  number INT,
  district VARCHAR(255),
  FOREIGN KEY (point_of_care_type_id) REFERENCES point_of_care_type(id) ON DELETE NO ACTION ON UPDATE CASCADE
);
