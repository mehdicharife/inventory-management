package ma.nemo.assignment.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Supplies")
public class Supply {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long supplyId;

  @ManyToOne
  private ProductModel productModel;

  private Integer quantity;

  @Temporal(TemporalType.TIMESTAMP)
  private Date expirationDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date supplyDate;



  public Long getSupplyId() {
    return supplyId;
  }

  public void setSupplyId(Long supplyId) {
    this.supplyId = supplyId;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  public void setProductModel(ProductModel productModel) {
    this.productModel = productModel;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer addedQuantity) {
    this.quantity = addedQuantity;
  }

  public Date getExpirationDate() {
    return this.expirationDate;
  }

  public void setExpirationDate(Date date) {
    this.expirationDate = date;
  }

  public Date getSupplyDate() {
    return supplyDate;
  }

  public void setSupplyDate(Date supplyDate) {
    this.supplyDate = supplyDate;
  }

  // Getters, setters, etc.
}
