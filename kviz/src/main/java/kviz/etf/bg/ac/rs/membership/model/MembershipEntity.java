package kviz.etf.bg.ac.rs.membership.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "membership")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipEntity {

    @EmbeddedId
    private MembershipId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("chatroomId")
    @JoinColumn(name = "chatroom_id")
    private ChatroomEntity chatroom;

    @Embeddable
    @Getter
    @Setter
    public static class MembershipId implements Serializable {
        private Long userId;
        private Long chatroomId;
    }
}
