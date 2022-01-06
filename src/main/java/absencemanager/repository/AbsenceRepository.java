package absencemanager.repository;

import absencemanager.model.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    Absence findFirstByOrderByIdDesc();
}
