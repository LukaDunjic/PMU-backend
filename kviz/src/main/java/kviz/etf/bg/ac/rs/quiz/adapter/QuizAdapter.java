package kviz.etf.bg.ac.rs.quiz.adapter;

import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter {

    public static QuizDto convertEntityToDto(QuizEntity quizEntity) {
        QuizDto quizDto = new QuizDto();
        quizDto.setQuizId(quizEntity.getQuizId());
        quizDto.setChatroom(ChatroomAdapter.convertEntityToDto(quizEntity.getChatroom()));
        return quizDto;
    }

    public static QuizEntity convertDtoToEntity(QuizDto quizDto) {
        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setQuizId(quizDto.getQuizId());
        quizEntity.setChatroom(ChatroomAdapter.convertDtoToEntity(quizDto.getChatroom()));
        return quizEntity;
    }

    public static List<QuizDto> convertEntityToDtoList(List<QuizEntity> quizEntityList) {
        List<QuizDto> quizDtoList = new ArrayList<>();
        quizEntityList.forEach(element -> quizDtoList.add(convertEntityToDto(element)));
        return quizDtoList;
    }

    public static List<QuizEntity> convertDtoToEntityList(List<QuizDto> quizDtoList) {
        List<QuizEntity> quizEntityList = new ArrayList<>();
        quizDtoList.forEach(element -> quizEntityList.add(convertDtoToEntity(element)));
        return quizEntityList;
    }
}
