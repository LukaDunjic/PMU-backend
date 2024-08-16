-- Kreiranje tabele quiz
CREATE TABLE quiz (
    quiz_id INT AUTO_INCREMENT PRIMARY KEY,
    chatroom_id int NOT NULL,
    FOREIGN KEY (chatroom_id) REFERENCES chatroom(chatroom_id) ON DELETE CASCADE
);