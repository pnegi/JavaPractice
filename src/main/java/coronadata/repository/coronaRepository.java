package coronadata.repository;

import coronadata.model.coronaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface coronaRepository extends JpaRepository<coronaEntity, Integer> {
}
