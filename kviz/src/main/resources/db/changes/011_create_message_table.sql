CREATE TABLE message (
     message_id INT AUTO_INCREMENT PRIMARY KEY,
     message TEXT NOT NULL,
     chatroom_id INT NOT NULL,
     user_id INT NOT NULL,
     FOREIGN KEY (chatroom_id) REFERENCES chatroom(chatroom_id),
     FOREIGN KEY (user_id) REFERENCES user(user_id)
);
