-- Kreiranje tabele answer
CREATE TABLE answer (
    answer_id INT AUTO_INCREMENT PRIMARY KEY,
    body VARCHAR(255) NOT NULL,
    is_true BOOLEAN,
    question_id INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(question_id) ON DELETE CASCADE
);