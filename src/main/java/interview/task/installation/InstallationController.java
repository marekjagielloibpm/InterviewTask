package interview.task.installation;

import interview.task.address.AddressEntity;
import interview.task.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstallationController {

    private final InstallationService service;
    @GetMapping("/installation/{id}")
    public ResponseEntity<InstallationEntity> getProductById(Long id) {
        return ResponseEntity.ok((InstallationEntity) service.findById(id).orElseThrow());
    }

    @PostMapping("/installation/{productId}/{addressId}")
    public ResponseEntity<InstallationEntity> createProduct(@PathVariable Long addressId, @PathVariable Long productId) {
        return ResponseEntity.ok(service.schedule(addressId, productId));
    }

    @PatchMapping("/installation/{id}")
    public ResponseEntity<InstallationEntity> createProduct(@PathVariable Long id) {
        return ResponseEntity.ok(service.start(id));
    }
}
