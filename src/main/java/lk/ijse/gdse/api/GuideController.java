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

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin("*")
public class GuideController {
    private final GuideService guideService;

    public GuideController(GuideService vehicleService) {
        this.guideService = vehicleService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    GuiderDTO saveVehicle(
            @RequestPart String guide_name,
            @RequestPart String guide_address,
            @RequestPart int age,
            @RequestPart int contact_number,
            @RequestPart String gender,
            @RequestPart byte[] guide_image

    ){
        String guider_image= Base64.getEncoder().encodeToString(guide_image);
        GuiderDTO guiderDTO=new GuiderDTO();
        guiderDTO.setGuide_name(guide_name);
        guiderDTO.setAddress(guide_address);
        guiderDTO.setAge(age);
        guiderDTO.setContact_number(contact_number);
        guiderDTO.setGender(gender);
        guiderDTO.setProfile_picture(guider_image);
        return guideService.saveGuide(guiderDTO);
    }
    @GetMapping(value = "{guide_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    GuiderDTO getSelecterGuide(@PathVariable String guide_id){
         return guideService.getGuide(guide_id);
    }
    /*@GetMapping(value = "/{guide_id}")
    ResponseEntity<GuiderDTO> getVehicle(@Valid @PathVariable String guide_id){
        return  null;
    }*/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{guide_id}")
    void deleteGuide(@Valid @PathVariable String guide_id){
  guideService.deleteGuide(guide_id);

    }

    @PatchMapping(value = "/{guide_id}")
    void updateGuide(@Valid @PathVariable String guide_id,@RequestBody GuiderDTO guiderDTO,Errors errors){
      guiderDTO.setGuide_id(guide_id);
        guideService.updateGuide(guiderDTO);
    }
}
