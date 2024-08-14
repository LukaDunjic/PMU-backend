package kviz.etf.bg.ac.rs.chatroom.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chatroom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatroomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatroom_id")
    private Integer chatroomId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner")
    private UserEntity owner;

}
