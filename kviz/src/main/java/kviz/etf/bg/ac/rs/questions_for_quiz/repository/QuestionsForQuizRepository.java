package kviz.etf.bg.ac.rs.questions_for_quiz.repository;

import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.questions_for_quiz.model.QuestionsForQuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionsForQuizRepository extends JpaRepository<QuestionsForQuizEntity, Integer> {

    @Query("SELECT qe FROM QuestionsForQuizEntity qq, QuestionsEntity qe, QuizEntity qze WHERE " +
            "qq.questionId = qe.questionId " +
            "and qq.quizId = qze.quizId and qq.quizId = ?1")
    List<QuestionsEntity> getQuestionsForQuiz(@Param("quizId") Integer quizId);
}
