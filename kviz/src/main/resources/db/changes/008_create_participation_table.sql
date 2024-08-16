-- Kreiranje tabele participation
CREATE TABLE participation (
      participation_id INT AUTO_INCREMENT PRIMARY KEY,
      result FLOAT NOT NULL,
      quiz_id INT NOT NULL,
      FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id) ON DELETE CASCADE,
      user_id INT NOT NULL,
      FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE
);