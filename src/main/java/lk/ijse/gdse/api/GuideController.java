package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.service.GuideService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin("*")
public class GuideController {
    private final GuideService guideService;

    public GuideController(GuideService vehicleService) {
        this.guideService = vehicleService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GuiderDTO saveGuide(@Valid
                               @RequestPart String guide_name,
                               @RequestPart String guide_address,
                               @RequestPart String age,
                               @RequestPart String contact_number,
                               @RequestPart String gender,
                               @RequestPart String experience,
                               @RequestPart String man_day_value,
                               @RequestPart String remark,
                               @RequestPart byte[] guide_image,
                               @RequestPart byte[] guide_nic_image,
                               @RequestPart byte[] guide_id_image
    ) {
        String guider_image = Base64.getEncoder().encodeToString(guide_image);
        String guider_nic_image = Base64.getEncoder().encodeToString(guide_nic_image);
        String guider_id_image = Base64.getEncoder().encodeToString(guide_id_image);

        GuiderDTO guiderDTO = new GuiderDTO();
        guiderDTO.setGuide_name(guide_name);
        guiderDTO.setAddress(guide_address);
        guiderDTO.setAge(age);
        guiderDTO.setContact_number(contact_number);
        guiderDTO.setGender(gender);
        guiderDTO.setExperience(experience);
        guiderDTO.setMan_day_value(Double.parseDouble(man_day_value));
        guiderDTO.setRemark(remark);
        guiderDTO.setProfile_picture(guider_image);
        guiderDTO.setGuide_nic_image(guider_nic_image);
        guiderDTO.setGuide_id_image(guider_id_image);

        System.out.println(guiderDTO.getGuide_id());
        return guideService.saveGuide(guiderDTO);
        //return guideService.saveGuide(guiderDTO);
    }

    @GetMapping(value = "/{guide_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuiderDTO> getSelecterGuide(@PathVariable String guide_id) {
        GuiderDTO guide = guideService.getGuide(guide_id);
        return new ResponseEntity<>(guide, HttpStatus.OK);
//         return guideService.getGuide(guide_id);
    }
    /*@GetMapping(value = "/{guide_id}")
    ResponseEntity<GuiderDTO> getVehicle(@Valid @PathVariable String guide_id){
        return  null;
    }*/

    @DeleteMapping(value = "/{guide_id}")
    void deleteGuide(@Valid @PathVariable String guide_id) {
        guideService.deleteGuide(guide_id);

    }

    @PatchMapping(value = "/{guide_id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateGuide(
            @PathVariable String guide_id,
            @RequestPart String guide_name,
            @RequestPart String guide_address,
            @RequestPart String age,
            @RequestPart String contact_number,
            @RequestPart String gender,
            @RequestPart String experience,
            @RequestPart double man_day_value,
            @RequestPart String remark,
            @RequestPart byte[] guide_image,
            @RequestPart byte[] guide_nic_image,
            @RequestPart byte[] guide_id_image
    ) {

        String guider_image = Base64.getEncoder().encodeToString(guide_image);
        String guider_nic_image = Base64.getEncoder().encodeToString(guide_nic_image);
        String guider_id_image = Base64.getEncoder().encodeToString(guide_id_image);
        GuiderDTO guiderDTO = new GuiderDTO();
        guiderDTO.setGuide_name(guide_name);
        guiderDTO.setAddress(guide_address);
        guiderDTO.setAge(age);
        guiderDTO.setContact_number(contact_number);
        guiderDTO.setGender(gender);
        guiderDTO.setExperience(experience);
        guiderDTO.setMan_day_value(man_day_value);
        guiderDTO.setRemark(remark);
        guiderDTO.setProfile_picture(guider_image);
        guiderDTO.setGuide_nic_image(guider_nic_image);
        guiderDTO.setGuide_id_image(guider_id_image);

        System.out.println(guiderDTO.getGuide_id());
        guideService.updateGuide(guide_id, guiderDTO);


        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }
    @GetMapping
    public ResponseEntity<List<GuiderDTO>> getAllGuide() {
        List<GuiderDTO> dto = guideService.getAllGuides();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    /*public void getAllGuides(){
        GuiderDTO dto=
   }*/
/*    @ResponseBody
    @GetMapping
    ResponseEntity<GuiderDTO> getAllGuides() {
        GuiderDTO dto=  guideService.getAll();
        return new ResponseEntity<>(dto,HttpStatus.OK);
       *//* return (ResponseEntity<GuiderDTO>) guideService.getAll();*//*

    }*/

}
