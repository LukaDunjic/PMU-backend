package kviz.etf.bg.ac.rs.chat;

import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.service.ChatroomService;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MessageControllerWS {


    final MessageRepository messageRepository; // Repository za čuvanje poruka
    final ChatroomService chatroomService;
    final UserService userService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/chatroom/{chatroomId}")
    public MessageEntity sendMessage(@Payload MessageEntity chatMessage, @DestinationVariable Integer chatroomId) {
        // Čuvanje poruke u bazi
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(chatMessage.getMessage());
        messageEntity.setChatroom(ChatroomAdapter.convertDtoToEntity(chatroomService.getCharoomById(chatroomId)));
        messageEntity.setSender(UserAdapter.convertDtoToEntity(userService.getUserById(chatMessage.getSender().getUserid())));
        messageRepository.save(messageEntity);

        return chatMessage;
    }
}

