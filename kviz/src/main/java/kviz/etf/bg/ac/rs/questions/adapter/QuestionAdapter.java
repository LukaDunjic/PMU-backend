package kviz.etf.bg.ac.rs.questions.adapter;

import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.sections.adapter.SectionAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter {

    public static QuestionDto convertEntityToDto(QuestionsEntity questionsEntity) {

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQId(questionsEntity.getQuestionId());
        questionDto.setQuestions(questionsEntity.getQuestionBody());
        questionDto.setAnswersDto(AnswerAdapter.convertEntityToDtoList(questionsEntity.getAnswersEntityList()));
        return questionDto;
    }

    public static List<QuestionDto> convertEntityToDtoList(List<QuestionsEntity> questionsEntityList) {

        List<QuestionDto> questionDtoList = new ArrayList<>();

        questionsEntityList.forEach(element -> {
            questionDtoList.add(convertEntityToDto(element));
        });

        return questionDtoList;
    }

    public static QuestionsEntity convertDtoToEntity(QuestionDto questionDto) {

        QuestionsEntity questionsEntity = new QuestionsEntity();

        questionsEntity.setQuestionBody(questionDto.getQuestions());
        questionsEntity.setSection(SectionAdapter.convertDtoToEntity(questionDto.getSection()));
        if(questionDto.getAnswersDto() != null)questionsEntity.setAnswersEntityList(AnswerAdapter.convertDtoToEntityList(questionDto.getAnswersDto()));

        return questionsEntity;
    }

    public static List<QuestionsEntity> convertDtoToEntityList(List<QuestionDto> questionDtoList) {

        List<QuestionsEntity> questionsEntityList = new ArrayList<>();

        questionDtoList.forEach(element -> {
            questionsEntityList.add(convertDtoToEntity(element));
        });

        return questionsEntityList;
    }
}
