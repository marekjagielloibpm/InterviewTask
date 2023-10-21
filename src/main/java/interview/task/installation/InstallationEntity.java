package interview.task.installation;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "installation")
public class InstallationEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long addressId;

    private Long productId;

    @Enumerated(EnumType.STRING)
    private InstallationStatus status;

    private boolean isVIP = false;

    private boolean isVillage = false;

    public InstallationEntity(Long addressId, Long productId, InstallationStatus status) {
        this.addressId = addressId;
        this.productId = productId;
        this.status = status;
    }
}
