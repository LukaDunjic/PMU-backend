package kviz.etf.bg.ac.rs.participation.dto;

import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.user.dto.UserDto;
import lombok.Data;

@Data
public class ParticipationDto {
    private Integer participationId;
    private Float result;
    private UserDto userDto;
    private QuizDto quizDto;
}
