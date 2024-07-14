package kviz.etf.bg.ac.rs.sections.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.Response.PmuResponse;
import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.sections.repository.SectionRepository;
import kviz.etf.bg.ac.rs.sections.service.SectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sections")
@Tag(name = "Section controller", description = "Rest APIs related to section.")
public class SectionController {

    SectionService sectionService;
    @GetMapping(value = "/allSections")
    @Operation(summary = "Getting all sections")
    public PmuResponse<List<SectionDto>> allSections(){
        return sectionService.getAllSections();
    }

    @GetMapping(value = "/newSection")
    @Operation(summary = "Creating new section")
    public PmuResponse<SectionDto> createSection(SectionDto sectionDto){
        return sectionService.addSection(sectionDto);
    }

    @GetMapping(value = "/getUserSection")
    @Operation(summary = "Getting section for user")
    public PmuResponse<List<SectionDto>> getUserSections(Integer userId){
        return null;
    }

    @GetMapping(value = "/deleteSection")
    public PmuResponse<SectionDto> deleteSection(Integer sectionId){
        return sectionService.deleteSection(sectionId);
    }
}
