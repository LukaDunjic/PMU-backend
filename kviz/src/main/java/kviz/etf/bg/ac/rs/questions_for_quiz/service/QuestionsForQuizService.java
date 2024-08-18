package kviz.etf.bg.ac.rs.questions_for_quiz.service;

import jakarta.transaction.Transactional;
import kviz.etf.bg.ac.rs.questions.adapter.QuestionAdapter;
import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.questions_for_quiz.model.QuestionsForQuizEntity;
import kviz.etf.bg.ac.rs.questions_for_quiz.repository.QuestionsForQuizRepository;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsForQuizService {

    final QuestionsForQuizRepository questionsForQuizRepository;

    public List<QuestionDto> getQuestionsForQuiz(Integer quizId){
        if(quizId == null){
            return null;
        }
        List<QuestionsEntity> questionsEntityList = questionsForQuizRepository.getQuestionsForQuiz(quizId);
        if(questionsEntityList != null){
            return QuestionAdapter.convertEntityToDtoList(questionsEntityList);
        }
        return null;
    }


    public String addQuestionForQuiz(Integer quizId, Integer questionId){
        QuestionsForQuizEntity questionsForQuizEntity = new QuestionsForQuizEntity();
        questionsForQuizEntity.setQuizId(quizId);
        questionsForQuizEntity.setQuestionId(questionId);
        questionsForQuizRepository.save(questionsForQuizEntity);
        return "Success.";
    }
}
