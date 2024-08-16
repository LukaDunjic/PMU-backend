package kviz.etf.bg.ac.rs.membership.service;

import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.service.ChatroomService;
import kviz.etf.bg.ac.rs.membership.model.MembershipEntity;
import kviz.etf.bg.ac.rs.membership.repository.MembershipRepository;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {

    final UserService userService;
    final ChatroomService chatroomService;
    final MembershipRepository membershipRepository;
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
}
