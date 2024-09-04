package kviz.etf.bg.ac.rs.section_ownership;

import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SectionOwnershipRepository extends JpaRepository<SectionOwnershipEntity, Integer> {

    @Query("select se from SectionOwnershipEntity so, SectionEntity se where so.owner.userid = ?1 and so.section.sectionId = se.sectionId")
    List<SectionEntity> getSectionsByUserId(@PathVariable("userId") Integer userId);

}
