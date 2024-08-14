package kviz.etf.bg.ac.rs.chatroom.repository;

import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatroomRepository extends JpaRepository<ChatroomEntity, Integer> {

    @Query("SELECT cr FROM ChatroomEntity cr WHERE cr.chatroomId = ?1")
    public ChatroomEntity getChatroomById(@Param("chatroomId") Integer chatroomId);
}
