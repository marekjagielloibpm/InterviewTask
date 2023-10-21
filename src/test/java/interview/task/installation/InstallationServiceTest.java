package interview.task.installation;

import interview.task.address.AddressEntity;
import interview.task.address.AddressRepository;
import interview.task.product.ProductEntity;
import interview.task.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InstallationServiceTest {

    @Autowired
    InstallationService installationService;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    void shouldRunInstallationIfScheduled() {
        AddressEntity address = addressRepository.save(new AddressEntity(
                "street",
                "Warszawa",
                "state",
                "11-111",
                "Poland"
        ));

        ProductEntity product = productRepository.save(new ProductEntity(
                "name",
                2L
        ));
        InstallationEntity installation = installationService.schedule(address.getId(), product.getId());
        installation = installationService.start(installation.getId());
        assertEquals(InstallationStatus.IN_PROGRESS, installation.getStatus());
        assertEquals(true, installation.isVIP());
    }

    @Test
    void shouldCheckInstallationLimit() {
        AddressEntity address = addressRepository.save(new AddressEntity(
                "street",
                "city",
                "state",
                "11-111",
                "Poland"
        ));

        ProductEntity product = productRepository.save(new ProductEntity(
                "name",
                1L
        ));

        InstallationEntity installation1 = installationService.schedule(address.getId(), product.getId());
        installation1 = installationService.schedule(address.getId(), product.getId());
        InstallationEntity installation2 = installationService.schedule(address.getId(), product.getId());
        installation1 = installationService.start(installation1.getId());
        InstallationEntity installation3 = installationService.schedule(address.getId(), product.getId());

        assertNotNull(installation1);
        assertNull(installation2);
        assertNotNull(installation3);
    }
}