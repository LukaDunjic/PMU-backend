package kviz.etf.bg.ac.rs.quiz.dto;

import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import lombok.Data;

@Data
public class QuizDto {
    private Integer quizId;
    private ChatroomDto chatroom;
}
