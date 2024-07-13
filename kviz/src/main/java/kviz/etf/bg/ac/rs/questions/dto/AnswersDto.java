package kviz.etf.bg.ac.rs.questions.dto;

import lombok.Data;

import java.util.List;

@Data
public class AnswersDto {
    List<String> answers;
    Integer qId;
    Integer correctOne;
}
