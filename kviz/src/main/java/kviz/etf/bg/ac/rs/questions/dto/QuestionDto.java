package kviz.etf.bg.ac.rs.questions.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    Integer qId;
    String questions;
    Integer section;
    List<AnswersDto> answersDto;
}
