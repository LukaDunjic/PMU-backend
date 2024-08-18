package kviz.etf.bg.ac.rs.chatroom.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "chatroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizEntity> quizEntityList;
}
