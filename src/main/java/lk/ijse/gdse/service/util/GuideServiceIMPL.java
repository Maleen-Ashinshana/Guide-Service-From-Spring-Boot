package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.repo.GuideRepo;
import lk.ijse.gdse.service.GuideService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuideServiceIMPL implements GuideService {
    @Autowired
    private Converter converter;
    @Autowired
    private GuideRepo vehicleRepo;

    @Override
    public GuiderDTO saveGuide(GuiderDTO vehicleDTO) {
        return null;
    }

    @Override
    public GuiderDTO getGuide(String guide_id) {
        return null;
    }

    @Override
    public void updateGuide(GuiderDTO guiderDTO) {

    }

    @Override
    public void deleteGuide(String guide_id) {

    }
}
