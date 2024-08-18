package kviz.etf.bg.ac.rs.participation.adapter;

import kviz.etf.bg.ac.rs.participation.dto.ParticipationDto;
import kviz.etf.bg.ac.rs.participation.model.ParticipationEntity;
import kviz.etf.bg.ac.rs.quiz.adapter.QuizAdapter;
import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.user.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class ParticipationAdapter {

    public static ParticipationDto convertEntityToDto(ParticipationEntity participationEntity) {
        ParticipationDto participationDto = new ParticipationDto();
        participationDto.setResult(participationEntity.getResult());
        participationDto.setParticipationId(participationEntity.getParticipationId());
        participationDto.setUserDto(UserAdapter.convertEntityToDto(participationEntity.getUser()));
        participationDto.setQuizDto(QuizAdapter.convertEntityToDto(participationEntity.getQuiz()));
        return participationDto;
    }

    public static ParticipationEntity convertDtoToEntity(ParticipationDto participationDto) {
        ParticipationEntity participationEntity = new ParticipationEntity();
        participationEntity.setParticipationId(participationDto.getParticipationId());
        participationEntity.setResult(participationDto.getResult());
        participationEntity.setUser(UserAdapter.convertDtoToEntity(participationDto.getUserDto()));
        participationEntity.setQuiz(QuizAdapter.convertDtoToEntity(participationDto.getQuizDto()));
        return participationEntity;
    }

    public static List<ParticipationDto> convertEntityToDtoList(List<ParticipationEntity> participationEntityList) {
        List<ParticipationDto> participationDtoList = new ArrayList<>();
        participationEntityList.forEach(element -> participationDtoList.add(convertEntityToDto(element)));
        return participationDtoList;
    }

    public static List<ParticipationEntity> convertDtoToEntityList(List<ParticipationDto> participationDtoList) {
        List<ParticipationEntity> participationEntityList = new ArrayList<>();
        participationDtoList.forEach(element -> participationEntityList.add(convertDtoToEntity(element)));
        return participationEntityList;
    }
}
