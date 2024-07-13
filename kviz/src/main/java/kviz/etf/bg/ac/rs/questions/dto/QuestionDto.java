package kviz.etf.bg.ac.rs.questions.dto;

import lombok.Data;

@Data
public class QuestionDto {
    Integer qId;
    String questions;
    AnswersDto answersDto;
}
