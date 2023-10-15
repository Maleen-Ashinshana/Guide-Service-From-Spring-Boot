package lk.ijse.gdse.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
//@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideEntity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  guide_id;
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
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String profile_picture;
   /* @OneToMany(mappedBy = "guide")
    private List<MainTravelServiceEntity> mainTravelServiceEntities;*/

    public GuideEntity(String guide_id, String guide_name, String address, int age, int contact_number, String gender, String profile_picture) {
        this.guide_id = guide_id;
        this.guide_name = guide_name;
        this.address = address;
        this.age = age;
        this.contact_number = contact_number;
        this.gender = gender;
        this.profile_picture = profile_picture;
    }
}
