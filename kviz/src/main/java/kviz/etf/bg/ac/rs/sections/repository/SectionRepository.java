package kviz.etf.bg.ac.rs.sections.repository;

import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<SectionEntity, Integer> {

    //TODO: kada dodas usera proveri dal je null u sekciji i za tog usera koji trazi
    @Query("SELECT sec FROM SectionEntity sec")
    public List<SectionEntity> getAllSections();

    @Query("select count(q) from QuestionsEntity q, SectionEntity s where q.section.sectionId=s.sectionId and s.sectionId = ?1")
    public Integer getAllQuestionsForSection(@Param("sectionId") Integer sectionId);
}
