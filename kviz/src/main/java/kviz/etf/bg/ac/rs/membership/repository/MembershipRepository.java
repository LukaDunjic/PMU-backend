package kviz.etf.bg.ac.rs.membership.repository;

import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.membership.model.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembershipRepository extends JpaRepository<MembershipEntity, Integer> {

    @Query("SELECT m FROM MembershipEntity m WHERE m.user = ?1")
    public List<MembershipEntity> getUsersChatrooms(@Param("userId") Integer userId);

    @Query("SELECT m FROM MembershipEntity m WHERE m.chatroom = ?1")
    public List<MembershipEntity> getChatroomsUsers(@Param("chatroomId") Integer chatroomId);

    @Query("SELECT m FROM MembershipEntity m WHERE m.chatroom = ?1 and m.user = ?2")
    public MembershipEntity getMembership(@Param("chatroomId") Integer chatroomId, @Param("userId") Integer userId);

    @Query("SELECT m.chatroom FROM MembershipEntity m WHERE m.user.userid = ?1")
    public List<ChatroomEntity> getAllChatroomsForUser(@Param("userId") Integer userId);
}
