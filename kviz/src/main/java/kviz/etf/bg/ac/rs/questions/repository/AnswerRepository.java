package kviz.etf.bg.ac.rs.questions.repository;

import kviz.etf.bg.ac.rs.questions.model.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswersEntity, Integer> {

    @Query("SELECT a FROM AnswersEntity a WHERE a.questionEntity.questionId = ?1")
    public List<AnswersEntity> getAnswersForQuestion(@Param("questionId") Integer questionId);
}
