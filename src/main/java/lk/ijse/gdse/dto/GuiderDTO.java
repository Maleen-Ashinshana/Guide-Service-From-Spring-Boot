package lk.ijse.gdse.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@AllArgsConstructor
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
    @Pattern(regexp = "[A-Za-z 0-9]+")
    private String address;
    @NotNull(message = "Guide Age cannot be empty")
    @Pattern(regexp = "^(0?[1-9]|[1-9][0-9])$", message = "Age must be a valid number between 1 and 99")
    private String age;
    @NotNull(message = "Guide Contact Number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Guide Contact Number must be a 10-digit number")
    private String contact_number;
    @NotNull(message = "Guide Gender cannot be empty")
    private String gender;
    @NotNull(message = "Guide experience cannot be empty")
    private String experience;
    @NotNull(message = "Guide Man day Value cannot be empty")
    private double man_day_value;
    @NotNull(message = "Guide remark cannot be empty")
    private String  remark;
    @NotNull(message = "Guide Profile Picture cannot be empty")
    private String profile_picture;
    @NotNull(message = "Guide Nic Image cannot be empty")
    private String guide_nic_image;
    @NotNull(message = "Guide ID Picture cannot be empty")
    private String guide_id_image;

/*    private List<MainTravelServiceEntity> mainTravelServiceEntities;*/


}
