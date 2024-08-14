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

    @GetMapping(value = "/generateTenQuestions/{numberOfQuestions}/{section}")
    @Operation(summary = "Generating ten questions")
    public PmuResponse<List<QuestionDto>> generateQuestions(@PathVariable Integer numberOfQuestions, @PathVariable Integer section) {

        List<QuestionDto> questionDtoList = questionService.generateQuestions(numberOfQuestions, section);

        PmuResponse<List<QuestionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(questionDtoList);

        return pmuResponse;
    }

    @GetMapping(value = "/addQuestionsInSection")
    @Operation(summary = "Adding question")
    public PmuResponse<QuestionDto> addQuestionInSection(@RequestBody QuestionDto questionDto) {

        questionService.addQuestion(questionDto);

        PmuResponse<QuestionDto> pmuResponse = new PmuResponse<>();
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
