CREATE TABLE todo(
   id int PRIMARY KEY AUTO_INCREMENT,
   text VARCHAR(225),
   completed BOOLEAN,
   edit BOOLEAN,
   userId int,
   FOREIGN KEY (userId) REFERENCES user(id)
);
