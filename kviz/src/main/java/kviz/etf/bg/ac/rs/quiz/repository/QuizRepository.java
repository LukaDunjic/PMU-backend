package kviz.etf.bg.ac.rs.quiz.repository;

import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {

    @Query("SELECT q FROM QuizEntity q WHERE q.quizId = ?1")
    public QuizEntity getQuizById(@Param("quizId") Integer quizId);

    @Query("SELECT q FROM QuizEntity q WHERE q.chatroom.chatroomId = ?1")
    public List<QuizEntity> getAllQuizForChatroom(@Param("chatroomId") Integer chatrommId);
}
