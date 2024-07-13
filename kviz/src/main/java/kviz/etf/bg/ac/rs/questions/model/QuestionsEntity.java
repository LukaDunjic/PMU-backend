package kviz.etf.bg.ac.rs.questions.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.sections.SectionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Integer questionId;

    @Column(name = "questionBody")
    private String questionBody;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswersEntity> answersEntityList;

    @ManyToOne
    @JoinColumn(name = "sectionId")
    private SectionEntity section;
}
