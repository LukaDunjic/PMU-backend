package kviz.etf.bg.ac.rs.questions.dto;

import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    Integer qId;
    String questions;
    SectionDto section;
    List<AnswersDto> answersDto;
}
