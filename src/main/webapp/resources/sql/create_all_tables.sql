SET foreign_key_checks = 0;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS routes;
DROP TABLE IF EXISTS legs;
SET foreign_key_checks = 1;

CREATE TABLE addresses
(
  address_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  street VARCHAR(30),
  city VARCHAR(30),
  state VARCHAR(30),
  zip VARCHAR(30)
);

CREATE TABLE users
(
  user_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(50),
  address_home INT(10),

  FOREIGN KEY (address_home) REFERENCES addresses(address_id)
);

CREATE TABLE accounts
(
  account_id INT(10) AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(30) UNIQUE,
  password VARCHAR(64),
  user_id INT(10) UNIQUE,

  FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE routes
(
  route_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  distance DOUBLE,
  distance_unit VARCHAR(30),
  elevation DOUBLE,
  elevation_unit VARCHAR(30),

  address_start INT(10),
  user_id INT(10),

  FOREIGN KEY (address_start) REFERENCES addresses(address_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE legs
(
  leg_id INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  distance DOUBLE,
  distance_unit VARCHAR(30),
  elevation DOUBLE,
  elevation_unit VARCHAR(30),

  address_start INT(10),
  address_end INT(10),
  route_id INT(10),

  FOREIGN KEY (address_start) REFERENCES addresses(address_id),
  FOREIGN KEY (address_end) REFERENCES addresses(address_id),
  FOREIGN KEY (route_id) REFERENCES  routes(route_id)
);