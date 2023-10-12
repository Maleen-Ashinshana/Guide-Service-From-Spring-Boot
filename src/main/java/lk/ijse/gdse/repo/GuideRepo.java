package lk.ijse.gdse.repo;

import lk.ijse.gdse.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepo extends JpaRepository<GuideEntity, String> {
    GuideEntity save(GuideEntity guideEntity);
    GuideEntity getByGuide_id(String guide_id);
    void deleteByGuide_id(String guide_id);

}
