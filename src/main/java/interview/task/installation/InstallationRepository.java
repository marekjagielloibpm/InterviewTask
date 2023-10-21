package interview.task.installation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface InstallationRepository extends JpaRepository<InstallationEntity, Long> {
}
