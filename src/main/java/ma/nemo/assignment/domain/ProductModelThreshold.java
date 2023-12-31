package ma.nemo.assignment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ProductModelThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(unique = true, nullable = false)
    private ProductModel productModel;

    private Integer threshold;


    public ProductModelThreshold() {

    }

    public ProductModelThreshold(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public ProductModel getProductModel() {
        return this.productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
