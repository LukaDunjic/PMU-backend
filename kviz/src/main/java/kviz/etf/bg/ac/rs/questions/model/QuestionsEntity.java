package kviz.etf.bg.ac.rs.questions.model;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
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
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question_body")
    private String questionBody;

    @OneToMany(mappedBy = "questionEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswersEntity> answersEntityList;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionEntity section;
}
