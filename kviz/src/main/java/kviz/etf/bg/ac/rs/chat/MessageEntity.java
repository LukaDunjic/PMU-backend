package kviz.etf.bg.ac.rs.chat;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.participation.model.ParticipationEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private ChatroomEntity chatroom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity sender;
}
