package kviz.etf.bg.ac.rs.sections;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "section")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sectionId")
    private Integer sectionId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionsEntity> questionsEntityList;
}
