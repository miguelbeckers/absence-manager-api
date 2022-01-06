package absencemanager.repository;

import absencemanager.model.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
    Crew findFirstByOrderByIdDesc();
}
