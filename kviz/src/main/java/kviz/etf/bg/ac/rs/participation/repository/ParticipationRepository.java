package kviz.etf.bg.ac.rs.participation.repository;

import kviz.etf.bg.ac.rs.participation.model.ParticipationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface ParticipationRepository extends JpaRepository<ParticipationEntity, Integer> {

    @Query("SELECT p FROM ParticipationEntity p WHERE p.participationId = ?1")
    public ParticipationEntity getParticipationEntityById(@Param("participationId") Integer participationId);

    @Query("SELECT p FROM ParticipationEntity p WHERE p.user.userid = ?1")
    public List<ParticipationEntity> getResultByUserId(@Param("userId") Integer userId);

    @Query("SELECT p.user.username, p.result FROM ParticipationEntity p WHERE p.quiz.quizId = ?1")
    public HashMap<String, Float> getResultByQuiz(@Param("quizId") Integer quizId);

    @Query("select count(p) from ParticipationEntity p where p.user.userid=?1")
    public Integer getNumOfGames(@Param("userId") Integer userId);

    @Query("select sum(p.result) from ParticipationEntity p where p.user.userid=?1")
    public Float getSumResults(@Param("userId") Integer userId);

}
