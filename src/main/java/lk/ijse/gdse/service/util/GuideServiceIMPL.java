package lk.ijse.gdse.service.util;


import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.entity.GuideEntity;
import lk.ijse.gdse.exception.NotFoundException;
import lk.ijse.gdse.repo.GuideRepo;
import lk.ijse.gdse.service.GuideService;
import lk.ijse.gdse.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Optional<GuideEntity> byId = guideRepo.findById(guide_id);
        if (!byId.isPresent()){
            throw new NotFoundException( "Guide ID :"+guide_id + " Not Found");
        }
        return converter.toGuiderDTO(byId.get());
        //return  converter.toGuiderDTO(guideRepo.findAllById(guide_id).get());
        //return converter.toGuiderDTO(guideRepo.findAllById(guide_id).);
    }

    @Override
    public void updateGuide(String guide_id,GuiderDTO guiderDTO) {
        Optional<GuideEntity> guideEntity=guideRepo.findById(guide_id);
        if (!guideEntity.isPresent()){

            throw  new NotFoundException("Guide ID :" +guide_id+"Not Found");

        }
        GuideEntity guide=guideEntity.get();
        guide.setGuide_name(guiderDTO.getGuide_name());
        guide.setAddress(guiderDTO.getAddress());
        guide.setAge(guiderDTO.getAge());
        guide.setContact_number(guiderDTO.getContact_number());
        guide.setGender(guiderDTO.getGender());
        guide.setProfile_picture(guiderDTO.getProfile_picture());

        guideRepo.save(guide);

    }

    @Override
    public void deleteGuide(String guide_id) {
        Optional<GuideEntity> byId = guideRepo.findById(guide_id);
        if (!byId.isPresent()){
            throw new NotFoundException("Guide ID : "+guide_id+"Not Found");
        }
        guideRepo.deleteById(guide_id);
    }

    @Override
    public List<GuiderDTO> getAllGuides() {
        return  guideRepo.findAll().stream().map(guide-> converter.toGuiderDTO(guide)).collect(Collectors.toList());
    }

/*    @Override
    public GuiderDTO getAll() {
        *//*return converter.toGuiderDTO(guideRepo.findAll(converter.toGuiderEntity(g)));*//*
        return  guideRepo.findAll().stream().map(guide->converter.toGuiderDTO(guide)).toList();
    }*/


}
