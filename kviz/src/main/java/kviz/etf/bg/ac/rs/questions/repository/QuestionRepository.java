package kviz.etf.bg.ac.rs.questions.repository;

import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionsEntity, Integer> {

    @Query("SELECT qe FROM QuestionsEntity qe")
    List<QuestionsEntity> getAllQuestions();

    @Query("SELECT qe FROM QuestionsEntity qe WHERE qe.questionId = ?1")
    QuestionsEntity getById (@Param("qId") Integer qId);

    @Query("SELECT qe FROM QuestionsEntity qe WHERE qe.section.sectionId = ?1")
    List<QuestionsEntity> getAllQuestionsBySection(@Param("section") Integer section);
}
