package kviz.etf.bg.ac.rs.sections.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kviz.etf.bg.ac.rs.response.PmuResponse;
import kviz.etf.bg.ac.rs.sections.dto.SectionDto;
import kviz.etf.bg.ac.rs.sections.dto.SectionScreenDto;
import kviz.etf.bg.ac.rs.sections.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sections")
@Tag(name = "Section controller", description = "Rest APIs related to section.")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class SectionController {

    SectionService sectionService;
    @GetMapping(value = "/allSections")
    @Operation(summary = "Getting all sections")
    public PmuResponse<List<SectionDto>> allSections(){
        return sectionService.getAllSections();
    }

    @PostMapping(value = "/newSection/{userId}")
    @Operation(summary = "Creating new section")
    public PmuResponse<SectionDto> createSection(@RequestBody SectionDto sectionDto, @PathVariable("userId") Integer userId){
        return sectionService.addSection(sectionDto, userId);
    }

    @GetMapping(value = "/getUserSectionScreen/{userId}")
    @Operation(summary = "Getting section (screen) for user.")
    public PmuResponse<List<SectionScreenDto>> getUserSectionsScreen(@PathVariable("userId") Integer userId){
        return sectionService.getSectionForUserScreen(userId);
    }

    @GetMapping(value = "/getUserSection/{userId}")
    @Operation(summary = "Getting section for user")
    public PmuResponse<List<SectionDto>> getUserSections(@PathVariable("userId") Integer userId){
        return sectionService.getSectionForUser(userId);
    }

    @DeleteMapping(value = "/deleteSection")
    public PmuResponse<SectionDto> deleteSection(Integer sectionId){
        return sectionService.deleteSection(sectionId);
    }
}
