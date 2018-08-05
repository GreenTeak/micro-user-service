CREATE TABLE todo(
   id int PRIMARY KEY AUTO_INCREMENT,
   text VARCHAR(225),
   completed BOOLEAN,
   edit BOOLEAN,
   userid int
);
