package kviz.etf.bg.ac.rs.questions.adapter;

import kviz.etf.bg.ac.rs.questions.dto.AnswersDto;
import kviz.etf.bg.ac.rs.questions.model.AnswersEntity;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter {

    public static AnswersDto convertEntityToDto(AnswersEntity answersEntity) {

        AnswersDto answersDto = new AnswersDto();

        answersDto.setQId(answersEntity.getQuestionEntity().getQuestionId());
        answersDto.setAnswer(answersEntity.getBody());
        answersDto.setIsCorrect(answersEntity.getIsTrue());
        answersDto.setAnswerId(answersEntity.getAnswerId());

        return answersDto;
    }

    public static List<AnswersDto> convertEntityToDtoList(List<AnswersEntity> answersEntityList) {

        List<AnswersDto> answersDtoList = new ArrayList<>();

        answersEntityList.forEach(element -> {
            answersDtoList.add(convertEntityToDto(element));
        });

        return answersDtoList;
    }

    public static AnswersEntity convertDtoToEntity(AnswersDto answersDto) {

        AnswersEntity answersEntity = new AnswersEntity();

        answersEntity.setAnswerId(answersDto.getAnswerId());
        answersEntity.setBody(answersDto.getAnswer());
        answersEntity.setIsTrue(answersDto.getIsCorrect());

        return answersEntity;
    }

    public static List<AnswersEntity> convertDtoToEntityList(List<AnswersDto> answersDtoList) {

        List<AnswersEntity> answersEntityList = new ArrayList<>();

        answersDtoList.forEach(element -> {
            answersEntityList.add(convertDtoToEntity(element));
        });

        return answersEntityList;
    }
}
