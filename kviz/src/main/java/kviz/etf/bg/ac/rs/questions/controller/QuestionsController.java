package kviz.etf.bg.ac.rs.questions.controller;

import kviz.etf.bg.ac.rs.response.PmuResponse;
import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.service.QuestionService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping(value = "/questions")
@Tag(name = "Questions controller", description = "Rest APIs related to questions")
@AllArgsConstructor
@CrossOrigin(origins = "*") // Dopušta CORS samo za ovaj origin
public class QuestionsController {

    QuestionService questionService;

    @GetMapping(value = "/allQuestions")
    @Operation(summary = "Getting all questions")
    public PmuResponse<List<QuestionDto>> allQuestions() {

        List<QuestionDto> questionDtoList = questionService.getAllQuestions();

        PmuResponse<List<QuestionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(questionDtoList);

        return pmuResponse;
    }

    @GetMapping(value = "/generateTenQuestions/{chatroomId}/{section}/{userId}")
    @Operation(summary = "Generating ten questions")
    public PmuResponse<List<QuestionDto>> generateQuestionsRandom(@PathVariable Integer chatroomId, @PathVariable Integer section,
                                                                  @PathVariable Integer userId) {
        //Integer section, Integer chatroomId, Integer userId
        List<QuestionDto> questionDtoList = questionService.generateQuestions(section, chatroomId, userId);

        PmuResponse<List<QuestionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(questionDtoList);

        return pmuResponse;
    }

    @PostMapping(value = "/addQuestionsInSection")
    @Operation(summary = "Adding question")
    public PmuResponse<QuestionDto> addQuestionInSection(@RequestBody QuestionDto questionDto) {

        QuestionDto questionDto1 = questionService.addQuestion(questionDto);

        PmuResponse<QuestionDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setDto(questionDto1);
        pmuResponse.setIsValid(true);

        return pmuResponse;
    }

    @DeleteMapping(value = "/deleteQuestions/{qId}")
    @Operation(summary = "Deleting questions")
    public PmuResponse<QuestionDto> deleteQuestions(@PathVariable Integer qId) {

        questionService.deleteQuestion(qId);

        PmuResponse<QuestionDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }
}
