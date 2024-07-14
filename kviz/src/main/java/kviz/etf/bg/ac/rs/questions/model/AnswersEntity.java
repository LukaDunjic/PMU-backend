package kviz.etf.bg.ac.rs.questions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;

    @Column(name = "body")
    private String body;

    @Column(name = "isTrue")
    private Boolean isTrue;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionsEntity questionEntity;

}
