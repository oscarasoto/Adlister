CREATE DATABASE IF NOT EXISTS adlister_db;

USE adlister_db;
SHOW TABLES ;

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(250) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

SHOW TABLES ;

DESCRIBE users;
DESCRIBE ads;

CREATE USER 'adlister'@'localhost' IDENTIFIED BY 'codeup';
GRANT ALL PRIVILEGES ON adlister_db.* TO 'adlister'@'localhost';

INSERT INTO users (username,email,password) VALUES ('oscar','oscar@mail.com','password');
SELECT * FROM users;

INSERT INTO ads (user_id, title, description) VALUES (1,'playstation for sale','slightly used playstation');
SELECT * FROM ads;

DELETE FROM users WHERE id = 2;

ALTER TABLE users MODIFY password VARCHAR(250) NOT NULL;


SELECT char_length(password) FROM users;

SELECT * FROM users WHERE id = 3;

