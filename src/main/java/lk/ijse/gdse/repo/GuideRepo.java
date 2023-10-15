package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.GuideEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepo extends CrudRepository<GuideEntity, String> {
    GuideEntity save(GuideEntity guideEntity);
//    GuideEntity getByGuide_id(String guide_id);
//    void deleteByGuide_id(String guide_id);

}
