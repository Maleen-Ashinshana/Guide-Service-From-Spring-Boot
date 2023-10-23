package lk.ijse.gdse.repo;

import lk.ijse.gdse.dto.GuiderDTO;
import lk.ijse.gdse.entity.GuideEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepo extends CrudRepository<GuideEntity, String> {
    GuideEntity save(GuideEntity guideEntity);
//    GuideEntity getByGuide_id(String guide_id);
//    void deleteByGuide_id(String guide_id);
    /*List<GuiderDTO> f();*/
    List<GuideEntity> findAll();
}
