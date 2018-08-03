CREATE TABLE task(
   id int PRIMARY KEY AUTO_INCREMENT,
   content TEXT,
   todo_id int,
   FOREIGN KEY (todo_id)REFERENCES todo(id)
)