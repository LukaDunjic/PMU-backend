package kviz.etf.bg.ac.rs.questions.adapter;

import kviz.etf.bg.ac.rs.questions.dto.AnswersDto;
import kviz.etf.bg.ac.rs.questions.model.AnswersEntity;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter {

    public static AnswersDto convertEntityToDto(AnswersEntity answersEntity) {

        AnswersDto answersDto = new AnswersDto();

        answersDto.setQId(answersEntity.getAnswerId());
        answersDto.setAnswer(answersEntity.getBody());
        answersDto.setIsCorrect(answersEntity.getIsTrue());

        return answersDto;
    }

    public static List<AnswersDto> convertEntityListToDtoList(List<AnswersEntity> answersEntityList) {

        List<AnswersDto> answersDtoList = new ArrayList<>();

        answersEntityList.forEach(element -> {
            answersDtoList.add(convertEntityToDto(element));
        });

        return answersDtoList;
    }
}
