package interview.task.installation;

import interview.task.address.AddressEntity;
import interview.task.address.AddressRepository;
import interview.task.product.ProductEntity;
import interview.task.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class InstallationService {
    @Autowired
    InstallationRepository repository;

    @Autowired
    AddressRepository addressRepository;

    private Long scheduleCount = 0L;

    public InstallationEntity schedule(Long addressId, Long productId) {
        scheduleCount++;
        return repository.save(new InstallationEntity(
                addressId,
                productId,
                InstallationStatus.SCHEDULED
        ));
    }

    public InstallationEntity start(Long id) {
        InstallationEntity installation = repository.findById(id).orElseThrow();

        if (scheduleCount == 0) {
            installation.setStatus(InstallationStatus.CANCELLED);
        }

        if (installation.getStatus() == InstallationStatus.COMPLETED) {
            return installation;
        }

        if (installation.getStatus() != InstallationStatus.SCHEDULED) {
            return installation;
        }


        Optional<AddressEntity> address = addressRepository.findById(installation.getAddressId());
        if (address.get().getCity() == "Warszawa") {
            installation.setVIP(true);
        }

        if (address.get().getStreet() == null) {
            installation.setVillage(true);
        }

        installation.setStatus(InstallationStatus.IN_PROGRESS);
        return repository.save(installation);
    }

    public Optional<Object> findById(Long id) {
        return Optional.of(repository.findById(id));
    }
}
