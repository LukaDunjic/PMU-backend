package kviz.etf.bg.ac.rs.questions_for_quiz.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "questions_for_quiz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsForQuizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qq_id")
    private Integer qqId;

    @Column(name = "quiz_id")
    private Integer quizId;

    @Column(name = "question_id")
    private Integer questionId;
}
