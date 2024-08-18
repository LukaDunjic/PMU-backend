package kviz.etf.bg.ac.rs.participation.service;

import kviz.etf.bg.ac.rs.participation.adapter.ParticipationAdapter;
import kviz.etf.bg.ac.rs.participation.dto.ParticipationDto;
import kviz.etf.bg.ac.rs.participation.model.ParticipationEntity;
import kviz.etf.bg.ac.rs.participation.repository.ParticipationRepository;
import kviz.etf.bg.ac.rs.quiz.service.QuizService;
import kviz.etf.bg.ac.rs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    final ParticipationRepository participationRepository;
    final QuizService quizService;
    final UserService userService;

    public ParticipationDto getParticipationEntityById(Integer participationId) {
        if (participationId == null) {
            return null;
        }
        ParticipationEntity participationEntity = participationRepository.getParticipationEntityById(participationId);
        if (participationEntity != null) {
            return ParticipationAdapter.convertEntityToDto(participationEntity);
        }
        return null;
    }

    public List<ParticipationDto> getResultByUserId(Integer userId) {
        if (userId == null) {
            return null;
        }
        List<ParticipationEntity> participationEntityList = participationRepository.getResultByUserId(userId);
        if(participationEntityList!=null){
            return ParticipationAdapter.convertEntityToDtoList(participationEntityList);
        }
        return null;
    }

    public HashMap<String, Float> getResultByQuiz(Integer quizId){
        if(quizId == null) return null;
        return participationRepository.getResultByQuiz(quizId);
    }

    public String addParticipation(ParticipationDto participationDto){
        participationDto.setUserDto(userService.getUserById(participationDto.getUserDto().getUserId()));
        participationDto.setQuizDto(quizService.getQuizById(participationDto.getQuizDto().getQuizId()));
        ParticipationEntity participationEntity = ParticipationAdapter.convertDtoToEntity(participationDto);
        ParticipationEntity participationEntity1 = participationRepository.save(participationEntity);
        if(participationEntity1.getParticipationId()==null){
            return "Not succeed in adding new participation.";
        }
        return "Success.";
    }
}
