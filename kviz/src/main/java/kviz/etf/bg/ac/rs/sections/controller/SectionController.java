package kviz.etf.bg.ac.rs.sections.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.Response.PmuResponse;
import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sections")
@Tag(name = "Section controller", description = "Rest APIs related to section.")
public class SectionController {
    @GetMapping(value = "/allSections")
    @Operation(summary = "Getting all sections")
    public PmuResponse<List<SectionDto>> allSections(){

        PmuResponse<List<SectionDto>> pmuResponse = new PmuResponse<List<SectionDto>>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }

    @GetMapping(value = "/newSection")
    @Operation(summary = "Creating new section")
    public PmuResponse<SectionDto> createSection(SectionDto sectionDto){

        PmuResponse<SectionDto> pmuResponse = new PmuResponse<SectionDto>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }

    @GetMapping(value = "/newSection")
    @Operation(summary = "Creating new section")
    public PmuResponse<List<SectionDto>> getUserSections(Integer userId){

        PmuResponse<List<SectionDto>> pmuResponse = new PmuResponse<List<SectionDto>>();
        pmuResponse.setIsValid(true);
        return pmuResponse;
    }
}
