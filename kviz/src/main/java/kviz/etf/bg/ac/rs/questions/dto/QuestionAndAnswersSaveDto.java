package kviz.etf.bg.ac.rs.questions.dto;

import kviz.etf.bg.ac.rs.questions.model.AnswersEntity;
import lombok.Data;

import java.util.List;

@Data
public class QuestionAndAnswersSaveDto {
    private QuestionDto questionDto;
    private List<AnswersDto> answersDtoList;
    private Integer sectionId;
}
