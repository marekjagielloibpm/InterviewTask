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
}
