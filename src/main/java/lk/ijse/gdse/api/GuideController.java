package lk.ijse.gdse.api;

import jakarta.validation.Valid;
import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.service.GuideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/guide")
public class GuideController {
    private final GuideService vehicleService;

    public GuideController(GuideService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    GuiderDTO saveVehicle(@Valid @RequestBody GuiderDTO guiderDTO, Errors errors){
        return null;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuiderDTO> getVehicle(@Valid @PathVariable String guide_id){
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping()
    void deleteGuide(@Valid @PathVariable String guide_id,@RequestBody GuiderDTO guiderDTO,Errors errors){

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping()
    void updateGuide(@Valid @PathVariable String guide_id,@RequestBody GuiderDTO guiderDTO,Errors errors){

    }
}
