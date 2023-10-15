package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.entity.GuideEntity;
import lk.ijse.gdse.repo.GuideRepo;
import lk.ijse.gdse.service.GuideService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class GuideServiceIMPL implements GuideService {
    @Autowired
    private Converter converter;
    @Autowired
    private GuideRepo guideRepo;

    @Override
    public GuiderDTO saveGuide(GuiderDTO guiderDTO) {

        return converter.toGuiderDTO(guideRepo.save(converter.toGuiderEntity(guiderDTO)));
    }

    @Override
    public GuiderDTO getGuide(String guide_id) {
    return converter.toGuiderDTO(guideRepo.findById(guide_id).get());
        //return  converter.toGuiderDTO(guideRepo.findAllById(guide_id).get());
        //return converter.toGuiderDTO(guideRepo.findAllById(guide_id).);
    }

    @Override
    public void updateGuide(GuiderDTO guiderDTO) {
        Optional<GuideEntity> guideEntity=guideRepo.findById(guiderDTO.getGuide_id());
        if (!guideEntity.isPresent()){
            guideEntity.get().setGuide_name(guiderDTO.getGuide_name());
            guideEntity.get().setAddress(guiderDTO.getAddress());
            guideEntity.get().setAge(guiderDTO.getAge());
            guideEntity.get().setContact_number(guiderDTO.getContact_number());
            guideEntity.get().setGender(guiderDTO.getGender());
            guideEntity.get().setProfile_picture(guiderDTO.getProfile_picture());
        }

    }

    @Override
    public void deleteGuide(String guide_id) {
    guideRepo.deleteById(guide_id);
    }
}
