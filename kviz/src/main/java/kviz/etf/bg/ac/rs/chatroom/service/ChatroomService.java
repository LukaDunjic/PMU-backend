package kviz.etf.bg.ac.rs.chatroom.service;

import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.chatroom.repository.ChatroomRepository;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatroomService {
    final ChatroomRepository chatroomRepository;
    final UserService userService;
    public ChatroomDto getCharoomById(Integer chatroomId){
        ChatroomEntity chatroomEntity = chatroomRepository.getChatroomById(chatroomId);
        if(chatroomEntity != null){
            return ChatroomAdapter.convertEntityToDto(chatroomEntity);
        }
        return null;
    }

    public ChatroomDto addChatroom(ChatroomDto chatroomDto){
        if(chatroomDto.getName() == null || chatroomDto.getOwner() == null || userService.getUserById(chatroomDto.getOwner().getUserId()) == null){
            return null;
        }
        ChatroomEntity chatroomEntity = chatroomRepository.save(ChatroomAdapter.convertDtoToEntity(chatroomDto));
        return ChatroomAdapter.convertEntityToDto(chatroomEntity);
    }

    public String deleteChatroom(Integer chatroomId){
        if(chatroomRepository.getChatroomById(chatroomId) == null){
            return "Chatroom does not exists";
        }
        chatroomRepository.deleteById(chatroomId);
        return "Success.";
    }

}
