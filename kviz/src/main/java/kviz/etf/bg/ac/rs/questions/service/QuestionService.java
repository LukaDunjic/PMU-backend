package kviz.etf.bg.ac.rs.questions.service;

import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.questions.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    QuestionRepository questionRepository;
    public List<QuestionsEntity> getAllQuestions(){

        //call repository
        return questionRepository.getAllQuestions();
    }

    public QuestionsEntity getSpecificQuestion(Integer qId){

        return questionRepository.getById(qId);
    }

    public void deleteQuestion(QuestionsEntity question){
        questionRepository.delete(question);
    }

    public List<QuestionsEntity> generateQuestions(Integer numberOfQuestions, Integer section){

        return null;
    }


}
