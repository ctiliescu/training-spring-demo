CREATE DATABASE mobile_academy;


CREATE TABLE `mobile_academy`.`evenimente` (
  `id` INT NOT NULL,
  `nume` VARCHAR(45) NOT NULL,
  `descriere` VARCHAR(45) NULL,
  `oraInceput` DATE NOT NULL,
  `oraFinal` DATE NOT NULL,
  PRIMARY KEY (`id`));


 ALTER TABLE document MODIFY COLUMN document_id INT auto_increment


