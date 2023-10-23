package lk.ijse.gdse.service;

import lk.ijse.gdse.dto.GuiderDTO;

import java.util.List;

public interface GuideService {
    GuiderDTO saveGuide(GuiderDTO vehicleDTO);
    GuiderDTO getGuide(String guide_id);
    void updateGuide(String guide_id,GuiderDTO guiderDTO);
    void deleteGuide(String guide_id);
    List<GuiderDTO> getAllGuides();
}
