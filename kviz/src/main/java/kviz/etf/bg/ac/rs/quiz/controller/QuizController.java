package kviz.etf.bg.ac.rs.quiz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.quiz.service.QuizService;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz")
@Tag(name = "Quiz controller.", description = "Rest APIs related to quiz.")
@AllArgsConstructor
public class QuizController {

    final QuizService quizService;

    @GetMapping(value = "/getQuizById/{quizId}")
    @Operation(summary = "Getting quiz by quizId.")
    public PmuResponse<QuizDto> getQuizById(@PathVariable Integer quizId) {
        QuizDto quizDto = quizService.getQuizById(quizId);

        PmuResponse<QuizDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(quizDto != null);
        pmuResponse.setDto(quizDto);

        return pmuResponse;
    }

    @GetMapping(value = "/getQuizByChatroom/{chatroomId}")
    @Operation(summary = "Getting quiz by quizId.")
    public PmuResponse<List<QuizDto>> getQuizByChatroom(@PathVariable Integer chatroomId) {
        List<QuizDto> quizDtoList = quizService.allQuizForChatroom(chatroomId);

        PmuResponse<List<QuizDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(quizDtoList != null);
        pmuResponse.setDto(quizDtoList);

        return pmuResponse;
    }
}
