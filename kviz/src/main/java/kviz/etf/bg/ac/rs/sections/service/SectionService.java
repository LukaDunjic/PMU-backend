package kviz.etf.bg.ac.rs.sections.service;

import kviz.etf.bg.ac.rs.response.PmuResponse;
import kviz.etf.bg.ac.rs.section_ownership.SectionOwnershipEntity;
import kviz.etf.bg.ac.rs.section_ownership.SectionOwnershipRepository;
import kviz.etf.bg.ac.rs.sections.adapter.SectionAdapter;
import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.dto.SectionScreenDto;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.sections.repository.SectionRepository;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import kviz.etf.bg.ac.rs.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    final SectionRepository sectionRepository;
    final UserRepository userRepository;
    final SectionOwnershipRepository sectionOwnershipRepository;
    public PmuResponse<List<SectionDto>> getAllSections(){

        //poziv repo
        List<SectionEntity> sectionEntitiesList = sectionRepository.getAllSections();

        PmuResponse<List<SectionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(true);
        pmuResponse.setDto(SectionAdapter.convertEntityToDtoList(sectionEntitiesList));
        return pmuResponse;
    }

    public PmuResponse<SectionDto> addSection(SectionDto sectionDto, Integer userId){

        UserEntity userEntity = userRepository.getUserById(userId);
        SectionEntity sectionEntity = sectionRepository.save(SectionAdapter.convertDtoToEntity(sectionDto));

        SectionOwnershipEntity sectionOwnership = new SectionOwnershipEntity();
        sectionOwnership.setOwner(userEntity);
        sectionOwnership.setSection(sectionEntity);
        sectionOwnershipRepository.save(sectionOwnership);

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

    public PmuResponse<List<SectionScreenDto>> getSectionForUserScreen(Integer userId){

        List<SectionEntity> sectionEntityList = sectionOwnershipRepository.getSectionsByUserId(userId);
        List<SectionDto> sectionDtoList = SectionAdapter.convertEntityToDtoList(sectionEntityList);
        List<SectionScreenDto> sectionScreenDtoList = new ArrayList<>();

        sectionDtoList.forEach(element->{
            sectionScreenDtoList.add(new SectionScreenDto(element, sectionRepository.getAllQuestionsForSection(element.getSectionId())));
        });

        PmuResponse<List<SectionScreenDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(!sectionEntityList.isEmpty());
        pmuResponse.setDto(sectionScreenDtoList);
        return pmuResponse;
    }

    public PmuResponse<List<SectionDto>> getSectionForUser(Integer userId) {
        List<SectionEntity> sectionEntityList = sectionOwnershipRepository.getSectionsByUserId(userId);

        PmuResponse<List<SectionDto>> pmuResponse = new PmuResponse<>();
        pmuResponse.setIsValid(!sectionEntityList.isEmpty());
        pmuResponse.setDto(SectionAdapter.convertEntityToDtoList(sectionEntityList));
        return pmuResponse;
    }
}
