package lk.ijse.gdse.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@ToString
public class GuiderDTO {
    @Null(message = "Guide ID will auto generate")
    private String guide_id;
    @NotNull(message = "Guide name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String guide_name;
    @NotNull(message = "Guide Address cannot be empty")
    private String address;
    @NotNull(message = "Guide Age cannot be empty")
    private int age;
    @NotNull(message = "Guide Contact Number cannot be empty")
    private int contact_number;
    @NotNull(message = "Guide Gender cannot be empty")
    private String gender;
    @NotNull(message = "Guide Profile Picture cannot be empty")
    private String profile_picture;

/*    private List<MainTravelServiceEntity> mainTravelServiceEntities;*/

    public GuiderDTO(String guide_id, String guide_name, String address, int age, int contact_number, String gender, String profile_picture) {
        this.guide_id = guide_id;
        this.guide_name = guide_name;
        this.address = address;
        this.age = age;
        this.contact_number = contact_number;
        this.gender = gender;
        this.profile_picture = profile_picture;
    }
}
