package kviz.etf.bg.ac.rs.quiz.service;

import kviz.etf.bg.ac.rs.questions.adapter.QuestionAdapter;
import kviz.etf.bg.ac.rs.quiz.adapter.QuizAdapter;
import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import kviz.etf.bg.ac.rs.quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    final QuizRepository quizRepository;

    public QuizDto getQuizById(Integer quizId){
        QuizEntity quizEntity = quizRepository.getQuizById(quizId);
        if(quizEntity != null){
            return QuizAdapter.convertEntityToDto(quizEntity);
        }
        return null;
    }

    public List<QuizDto> allQuizForChatroom(Integer chatroomId){
        List<QuizEntity> quizEntityList = quizRepository.getAllQuizForChatroom(chatroomId);
        if(!quizEntityList.isEmpty()){
            return QuizAdapter.convertEntityToDtoList(quizEntityList);
        }
        return null;
    }

    public QuizEntity createQuizInternal(QuizDto quizDto){
        QuizEntity quizEntity = QuizAdapter.convertDtoToEntity(quizDto);
        return quizRepository.save(quizEntity);
    }
}
