package kviz.etf.bg.ac.rs.questions.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/questions")
@Tag(name = "Questions controller", description = "Rest APIs related to questions")
@AllArgsConstructor
public class QuestionsController {

    @GetMapping(value = "/allQuestions")
    @Operation(summary = "Getting all questions")
    public String allQuestions (){
        return "Hello world";
    }

    @GetMapping(value = "/generateTenQuestions")
    @Operation(summary = "Generating ten questions")
    public String generateTenQuestions (){
        return "Hello world";
    }

    @GetMapping(value = "/addQuestionsInSection")
    @Operation(summary = "Adding question")
    public String addQuestionInSection (){
        return "Hello world";
    }

    @DeleteMapping(value = "/deleteQuestions/<qId>")
    @Operation(summary = "Deleting questions")
    public String deleteQuestions (@PathVariable Integer qId){
        return "Hello world";
    }
}
