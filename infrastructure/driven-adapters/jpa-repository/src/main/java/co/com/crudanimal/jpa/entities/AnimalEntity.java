package co.com.crudanimal.jpa.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "tbanimal")
public class AnimalEntity {
    @Id private String id;
    @Column private String name;
    @Column private String gender;
    @Column private Long legs;
    @Column private String species;
    @Column private String habitat;

    @Column private Boolean domestic;
}
