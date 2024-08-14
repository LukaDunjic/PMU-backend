package kviz.etf.bg.ac.rs.user.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.chatroom.model.ChatroomEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "chatroomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatroomEntity> chatroomEntityList;
}
