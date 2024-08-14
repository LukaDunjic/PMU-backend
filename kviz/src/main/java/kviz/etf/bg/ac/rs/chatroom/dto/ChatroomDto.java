package kviz.etf.bg.ac.rs.chatroom.dto;

import kviz.etf.bg.ac.rs.user.dto.UserDto;
import lombok.Data;

@Data
public class ChatroomDto {
    private Integer chatroomId;
    private String name;
    private UserDto owner;
}
