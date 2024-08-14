package kviz.etf.bg.ac.rs.chatroom.adapter;

import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatroomAdapter {

    public static ChatroomDto convertEntityToDto(ChatroomEntity chatroomEntity){

        ChatroomDto chatroomDto = new ChatroomDto();
        chatroomDto.setName(chatroomEntity.getName());
        chatroomDto.setChatroomId(chatroomEntity.getChatroomId());
        chatroomDto.setOwner(UserAdapter.convertEntityToDto(chatroomEntity.getOwner()));

        return chatroomDto;
    }

    public static ChatroomEntity convertDtoToEntity(ChatroomDto chatroomDto){

        ChatroomEntity chatroomEntity = new ChatroomEntity();
        chatroomEntity.setName(chatroomDto.getName());
        chatroomEntity.setOwner(UserAdapter.convertDtoToEntity(chatroomDto.getOwner()));
        chatroomEntity.setChatroomId(chatroomDto.getChatroomId());

        return chatroomEntity;
    }

    public static List<ChatroomDto> convertEntityToDtoList(List<ChatroomEntity> chatroomEntityList){

        List<ChatroomDto> chatroomDtoList = new ArrayList<>();
        chatroomEntityList.forEach(element->chatroomDtoList.add(convertEntityToDto(element)));

        return chatroomDtoList;
    }

    public static List<ChatroomEntity> convertDtoToEntityList(List<ChatroomDto> chatroomDtoList){

        List<ChatroomEntity> chatroomEntityList = new ArrayList<>();
        chatroomDtoList.forEach(element->chatroomEntityList.add(convertDtoToEntity(element)));

        return chatroomEntityList;
    }
}
