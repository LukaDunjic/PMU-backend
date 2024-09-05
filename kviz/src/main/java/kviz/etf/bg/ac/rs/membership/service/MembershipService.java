package kviz.etf.bg.ac.rs.membership.service;

import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.chatroom.service.ChatroomService;
import kviz.etf.bg.ac.rs.membership.model.MembershipEntity;
import kviz.etf.bg.ac.rs.membership.repository.MembershipRepository;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import kviz.etf.bg.ac.rs.user.repository.UserRepository;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipService {

    final UserService userService;
    final ChatroomService chatroomService;
    final MembershipRepository membershipRepository;
    final UserRepository userRepository;
    public void joinChatroom(Integer userId, Integer chatroomId){
        MembershipEntity membershipEntity = new MembershipEntity();

        membershipEntity.setUser(UserAdapter.convertDtoToEntity(userService.getUserById(userId)));
        membershipEntity.setChatroom(ChatroomAdapter.convertDtoToEntity(chatroomService.getCharoomById(chatroomId)));

        membershipRepository.save(membershipEntity);
    }

    public void leaveChatroom(Integer userId, Integer chatroomId){

        MembershipEntity membershipEntity = membershipRepository.getMembership(chatroomId, userId);

        membershipRepository.delete(membershipEntity);

    }

    public List<ChatroomDto> getAllChatroomsForUser(Integer userId){
        List<ChatroomEntity> chatroomDtoList = membershipRepository.getAllChatroomsForUser(userId);
        if(chatroomDtoList == null){
            return null;
        }
        return ChatroomAdapter.convertEntityToDtoList(chatroomDtoList);
    }

    public void joinChatroomByUsername(String username, Integer chatroomId) {
        MembershipEntity membershipEntity = new MembershipEntity();
        UserEntity userEntity = userRepository.getUserByUsername(username);
        ChatroomEntity chatroomEntity =ChatroomAdapter.convertDtoToEntity(chatroomService.getCharoomById(chatroomId));
        membershipEntity.setUser(userEntity);
        membershipEntity.setChatroom(chatroomEntity);
        membershipEntity.setId(new MembershipEntity.MembershipId(userEntity.getUserid(),chatroomEntity.getChatroomId() ));
        membershipRepository.save(membershipEntity);
    }
}
