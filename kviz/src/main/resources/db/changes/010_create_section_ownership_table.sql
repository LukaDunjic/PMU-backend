CREATE TABLE section_ownership (
   so_id INT AUTO_INCREMENT PRIMARY KEY,
   section_id INT NOT NULL,
   owner INT NOT NULL,
   FOREIGN KEY (section_id) REFERENCES section(section_id),
   FOREIGN KEY (owner) REFERENCES user(user_id)
);
