package lk.ijse.gdse.util;


import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.entity.GuideEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    private final ModelMapper modelMapper;

    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GuideEntity toGuiderEntity(GuiderDTO guiderDTO){
        return modelMapper.map(guiderDTO, GuideEntity.class);
    }
    public  GuiderDTO toGuiderDTO(GuideEntity guideEntity){
        return modelMapper.map(guideEntity, GuiderDTO.class);
    }
}
