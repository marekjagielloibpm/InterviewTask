package interview.task.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductEntity> getProductById(Long id) {
        return ResponseEntity.ok(productRepository.findById(id).orElseThrow());
    }

    @PostMapping("/products")
    public ResponseEntity<ProductEntity> createProduct(ProductEntity product) {
        return ResponseEntity.ok(productRepository.save(product));
    }
}
