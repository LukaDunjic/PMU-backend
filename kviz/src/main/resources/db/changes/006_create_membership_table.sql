CREATE TABLE membership (
    user_id int NOT NULL,
    chatroom_id int NOT NULL,
    PRIMARY KEY (user_id, chatroom_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (chatroom_id) REFERENCES chatroom(chatroom_id)
);