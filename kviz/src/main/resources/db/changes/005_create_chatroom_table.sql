-- Kreiranje tabele chatroom
CREATE TABLE chatroom (
    chatroom_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner INT NOT NULL,
    FOREIGN KEY (owner) REFERENCES user(user_id) ON DELETE CASCADE
);