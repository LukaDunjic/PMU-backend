package kviz.etf.bg.ac.rs.questions.dto;

import lombok.Data;

@Data
public class AnswersDto {
    String answer;
    Integer questionId;
    Boolean isCorrect;
    Integer answerId;
}
