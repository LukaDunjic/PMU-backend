package kviz.etf.bg.ac.rs.sections.service;

import kviz.etf.bg.ac.rs.Response.PmuResponse;
import kviz.etf.bg.ac.rs.sections.adapter.SectionAdapter;
import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.sections.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    final SectionRepository sectionRepository;

    public PmuResponse<List<SectionDto>> getAllSections(){

        //poziv repo
        List<SectionEntity> sectionEntitiesList = sectionRepository.getAllSections();

        PmuResponse<List<SectionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(SectionAdapter.convertEntityToDtoList(sectionEntitiesList));
        return pmuResponse;
    }

    public PmuResponse<SectionDto> addSection(SectionDto sectionDto){

        sectionRepository.save(SectionAdapter.convertDtoToEntity(sectionDto));

        PmuResponse<SectionDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }

    public PmuResponse<SectionDto> deleteSection(Integer sectionId){

        sectionRepository.deleteById(sectionId);

        PmuResponse<SectionDto> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }
}
