package kviz.etf.bg.ac.rs.sections.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionScreenDto {
    private SectionDto sectionDto;
    private Integer numOfQuestions;
}
