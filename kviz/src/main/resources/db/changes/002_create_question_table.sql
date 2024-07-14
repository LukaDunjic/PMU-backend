-- Kreiranje tabele question
CREATE TABLE question (
      question_id INT AUTO_INCREMENT PRIMARY KEY,
      question_body VARCHAR(255) NOT NULL,
      section_id INT,
      FOREIGN KEY (section_id) REFERENCES section(section_id) ON DELETE CASCADE
);