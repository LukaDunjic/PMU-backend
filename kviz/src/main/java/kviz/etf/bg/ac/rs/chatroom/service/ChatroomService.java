package kviz.etf.bg.ac.rs.chatroom.service;

import jakarta.transaction.Transactional;
import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.chatroom.repository.ChatroomRepository;
import kviz.etf.bg.ac.rs.membership.model.MembershipEntity;
import kviz.etf.bg.ac.rs.membership.repository.MembershipRepository;
import kviz.etf.bg.ac.rs.membership.service.MembershipService;
import kviz.etf.bg.ac.rs.participation.model.ParticipationEntity;
import kviz.etf.bg.ac.rs.participation.service.ParticipationService;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatroomService {
    final ChatroomRepository chatroomRepository;
    final UserService userService;
    final MembershipRepository membershipService;

    public ChatroomDto getCharoomById(Integer chatroomId) {
        ChatroomEntity chatroomEntity = chatroomRepository.getChatroomById(chatroomId);
        if (chatroomEntity != null) {
            return ChatroomAdapter.convertEntityToDto(chatroomEntity);
        }
        return null;
    }

    @Transactional
    public ChatroomDto addChatroom(ChatroomDto chatroomDto) {
        if (chatroomDto.getName() == null || chatroomDto.getOwner() == null || userService.getUserById(chatroomDto.getOwner().getUserid()) == null) {
            return null;
        }
        ChatroomEntity chatroomEntity = chatroomRepository.save(ChatroomAdapter.convertDtoToEntity(chatroomDto));
        MembershipEntity membershipEntity =
                new MembershipEntity(new MembershipEntity.MembershipId
                        (chatroomEntity.getOwner().getUserid(), chatroomEntity.getChatroomId()), chatroomEntity.getOwner(), chatroomEntity);
        membershipService.save(membershipEntity);
        return ChatroomAdapter.convertEntityToDto(chatroomEntity);
    }

    public String deleteChatroom(Integer chatroomId) {
        if (chatroomRepository.getChatroomById(chatroomId) == null) {
            return "Chatroom does not exists";
        }
        chatroomRepository.deleteById(chatroomId);
        return "Success.";
    }

    public Boolean isOwner(Integer userId, Integer chatroomId) {
        return chatroomRepository.isOwner(userId, chatroomId) != null;
    }

}
