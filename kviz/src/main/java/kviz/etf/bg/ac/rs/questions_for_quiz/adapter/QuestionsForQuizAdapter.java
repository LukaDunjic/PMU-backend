package kviz.etf.bg.ac.rs.questions_for_quiz.adapter;

import kviz.etf.bg.ac.rs.questions_for_quiz.dto.QuestionsForQuizDto;
import kviz.etf.bg.ac.rs.questions_for_quiz.model.QuestionsForQuizEntity;

import java.util.ArrayList;
import java.util.List;

public class QuestionsForQuizAdapter {

    public static QuestionsForQuizDto convertEntityToDto(QuestionsForQuizEntity questionsForQuizEntity){
        QuestionsForQuizDto questionsForQuizDto = new QuestionsForQuizDto();
        questionsForQuizDto.setQuestionId(questionsForQuizEntity.getQuestionId());
        questionsForQuizDto.setQuizId(questionsForQuizEntity.getQuizId());
        questionsForQuizDto.setQqId(questionsForQuizEntity.getQqId());
        return questionsForQuizDto;
    }

    public static QuestionsForQuizEntity convertDtoToEntity(QuestionsForQuizDto questionsForQuizDto){
        QuestionsForQuizEntity questionsForQuizEntity = new QuestionsForQuizEntity();
        questionsForQuizEntity.setQqId(questionsForQuizDto.getQqId());
        questionsForQuizEntity.setQuestionId(questionsForQuizDto.getQuestionId());
        questionsForQuizEntity.setQuizId(questionsForQuizDto.getQuizId());
        return questionsForQuizEntity;
    }

    public static List<QuestionsForQuizDto> convertEntityToDtoList(List<QuestionsForQuizEntity> questionsForQuizEntitieList){
        List<QuestionsForQuizDto> questionsForQuizDtoList = new ArrayList<>();
        questionsForQuizEntitieList.forEach(element->questionsForQuizDtoList.add(convertEntityToDto(element)));
        return questionsForQuizDtoList;
    }

    public static List<QuestionsForQuizEntity> convertDtoToEntityList(List<QuestionsForQuizDto> questionsForQuizDtoList){
        List<QuestionsForQuizEntity> questionsForQuizEntityList = new ArrayList<>();
        questionsForQuizDtoList.forEach(element->questionsForQuizEntityList.add(convertDtoToEntity(element)));
        return questionsForQuizEntityList;
    }
}
