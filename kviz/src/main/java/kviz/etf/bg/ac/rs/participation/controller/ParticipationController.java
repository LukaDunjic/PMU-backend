package kviz.etf.bg.ac.rs.participation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.participation.dto.ParticipationDto;
import kviz.etf.bg.ac.rs.participation.service.ParticipationService;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/participations")
@Tag(name = "Participation controller.", description = "Rest APIs related to participation.")
@AllArgsConstructor
public class ParticipationController {

    final ParticipationService participationService;

    @GetMapping(value = "/getParticipationById/{participationId}")
    @Operation(summary = "Getting participation by participationId.")
    public PmuResponse<ParticipationDto> getParticipationById(@PathVariable Integer participationId) {
        ParticipationDto participationDto = participationService.getParticipationEntityById(participationId);

        PmuResponse<ParticipationDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(participationDto != null);
        pmuResponse.setDto(participationDto);

        return pmuResponse;
    }

    @GetMapping(value = "/getResultByUserId/{userId}")
    @Operation(summary = "Getting participation by userId.")
    public PmuResponse<List<ParticipationDto>> getResultByUserId(@PathVariable Integer userId) {
        List<ParticipationDto> participationDtoList = participationService.getResultByUserId(userId);

        PmuResponse<List<ParticipationDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(participationDtoList != null);
        pmuResponse.setDto(participationDtoList);

        return pmuResponse;
    }

    @GetMapping(value = "/getResultByQuizId/{quizId}")
    @Operation(summary = "Getting participation by quizId.")
    public PmuResponse<HashMap<String, Float>> getResultByQuiz(@PathVariable Integer quizId) {
        HashMap<String, Float> results = participationService.getResultByQuiz(quizId);

        PmuResponse<HashMap<String, Float>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(results != null);
        pmuResponse.setDto(results);

        return pmuResponse;
    }

    @PostMapping(value = "/addParticipation")
    @Operation(summary = "Adding participation.")
    public PmuResponse<String> addParticipation(@RequestBody ParticipationDto participationDto) {
        String message = participationService.addParticipation(participationDto);

        PmuResponse<String> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(!message.equals("Success."));
        pmuResponse.setDto(message);

        return pmuResponse;
    }
}
