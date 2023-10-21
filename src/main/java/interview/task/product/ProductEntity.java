package interview.task.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductEntityIdGenerator")
    private Long id;
    private String name;
    private String description;
    private String price;
    private String currency;
    private String category;
    private long installationLimit = 10;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, String price, String currency, String category, Long installationLimit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.category = category;
        this.installationLimit = installationLimit;
    }

    public ProductEntity(String name, Long installationLimit) {
        this.name = name;
        this.installationLimit = installationLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getInstallationLimit() {
        return installationLimit;
    }

    public void setInstallationLimit(long limit) {
        this.installationLimit = limit;
    }
}
