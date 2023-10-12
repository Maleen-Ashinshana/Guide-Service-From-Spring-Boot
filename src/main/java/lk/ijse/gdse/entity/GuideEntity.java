package lk.ijse.gdse.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "guide")
public class GuideEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guide_id;
    @Column(nullable = false)
    private String guide_name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private int contact_number;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String profile_picture;
   /* @OneToMany(mappedBy = "guide")
    private List<MainTravelServiceEntity> mainTravelServiceEntities;*/

    public GuideEntity(int guide_id, String guide_name, String address, int age, int contact_number, String gender, String profile_picture) {
        this.guide_id = guide_id;
        this.guide_name = guide_name;
        this.address = address;
        this.age = age;
        this.contact_number = contact_number;
        this.gender = gender;
        this.profile_picture = profile_picture;
    }
}
