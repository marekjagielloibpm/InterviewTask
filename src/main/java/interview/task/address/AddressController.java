package interview.task.address;

import interview.task.product.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepository addressRepository;

    @GetMapping("/address")
    public ResponseEntity<List<AddressEntity>> getAllProducts() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressEntity> getProductById(Long id) {
        return ResponseEntity.ok(addressRepository.findById(id).orElseThrow());
    }

    @PostMapping("/address")
    public ResponseEntity<AddressEntity> createProduct(AddressEntity product) {
        return ResponseEntity.ok(addressRepository.save(product));
    }
}
