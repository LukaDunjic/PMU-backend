package kviz.etf.bg.ac.rs.section_ownership;

import jakarta.persistence.*;
import kviz.etf.bg.ac.rs.sections.model.SectionEntity;
import kviz.etf.bg.ac.rs.user.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "section_ownership")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionOwnershipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "so_id")
    private Integer soId;

//    @Column(name = "section_idd")
//    private Integer sectionId;
//
//    @Column(name = "owner")
//    private Integer owner;
    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    private SectionEntity section;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "user_id")
    private UserEntity owner;

}
