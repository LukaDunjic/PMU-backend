package kviz.etf.bg.ac.rs.questions_for_quiz.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionsForQuizDto {
    private Integer qqId;
    private Integer quizId;
    private Integer questionId;
}
