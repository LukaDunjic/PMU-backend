package kviz.etf.bg.ac.rs.chatroom.repository;

import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatroomRepository extends JpaRepository<ChatroomEntity, Integer> {

    @Query("SELECT cr FROM ChatroomEntity cr WHERE cr.chatroomId = ?1")
    public ChatroomEntity getChatroomById(@Param("chatroomId") Integer chatroomId);

    @Query("SELECT cr.owner FROM ChatroomEntity cr WHERE cr.owner.userid = ?1 and cr.chatroomId = ?2")
    public UserEntity isOwner(@Param("userId") Integer userId, @Param("chatroomId") Integer chatroomId);
}
