package kviz.etf.bg.ac.rs.participation.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "participation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Integer participationId;

    @Column(name = "result")
    private Float result;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private QuizEntity quiz;
}
