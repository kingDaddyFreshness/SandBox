CREATE DATABASE jmhdb;

use jmhdb;

CREATE TABLE account (
   account_id INT NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100) NOT NULL,
   date_created DATE,
   PRIMARY KEY ( account_id )
);

INSERT INTO account (first_name, last_name, date_created) VALUES ("John", "Poul", NOW());

INSERT INTO account (first_name, last_name, date_created) VALUES ("George", "Ringo", NOW());

