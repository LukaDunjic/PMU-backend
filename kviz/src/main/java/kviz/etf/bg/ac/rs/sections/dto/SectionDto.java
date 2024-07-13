package kviz.etf.bg.ac.rs.sections.dto;

import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import lombok.Data;

import java.util.List;

@Data
public class SectionDto {
    Integer sectionId;
    String name;
    List<QuestionsEntity> questionsEntityList;
    Integer userId;
}
