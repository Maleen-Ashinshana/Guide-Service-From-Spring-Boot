package lk.ijse.gdse.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
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
    private String age;
    @Column(nullable = false)
    private String contact_number;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private double man_day_value;
    @Column(nullable = false)
    private String  remark;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String profile_picture;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String guide_nic_image;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String guide_id_image;

}
