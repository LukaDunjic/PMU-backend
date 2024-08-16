-- Kreiranje tabele questions_for_quiz
CREATE TABLE questions_for_quiz (
       qq_id INT AUTO_INCREMENT PRIMARY KEY,
       quiz_id INT NOT NULL,
       FOREIGN KEY (quiz_id) REFERENCES quiz(quiz_id) ON DELETE CASCADE,
       question_id INT NOT NULL,
       FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);