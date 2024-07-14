package kviz.etf.bg.ac.rs.sections.adapter;

import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter {

    public static SectionDto convertEntityToDto(SectionEntity sectionEntity){

        SectionDto sectionDto = new SectionDto();

        sectionDto.setSectionId(sectionEntity.getSectionId());
        sectionDto.setName(sectionEntity.getName());
        //TODO:Dodaj user id pravi kada dodas usera
        sectionDto.setUserId(1);
        return sectionDto;
    }

    public static List<SectionDto> convertEntityToDtoList(List<SectionEntity> sectionEntitiesList){

        List<SectionDto> sectionDtoList = new ArrayList<>();

        sectionEntitiesList.forEach(element->{
            sectionDtoList.add(convertEntityToDto(element));
        });

        return sectionDtoList;
    }

    public static SectionEntity convertDtoToEntity(SectionDto sectionDto){

        SectionEntity sectionEntity = new SectionEntity();

        sectionEntity.setSectionId(sectionDto.getSectionId());
        sectionEntity.setName(sectionDto.getName());
        //TODO:Dodaj user id pravi kada dodas usera

        return sectionEntity;
    }
}
