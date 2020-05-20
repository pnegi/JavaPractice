package coronadata.repository;

import coronadata.model.CoronaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaRepository extends JpaRepository<CoronaEntity, Integer> {
}
