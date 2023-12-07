package ma.nemo.assignment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Sales")
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long saleId;

  @ManyToOne
  private ProductModel productModel;

  private long quantity;

  private Double totalPrice;

  @Temporal(TemporalType.TIMESTAMP)
  private Date saleDate;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User buyer;

  public Long getSaleId() {
    return saleId;
  }

  public void setSaleId(Long saleId) {
    this.saleId = saleId;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  public void setProductModel(ProductModel productModel) {
    this.productModel = productModel;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(Date saleDate) {
    this.saleDate = saleDate;
  }

  public User getBuyer() {
    return buyer;
  }

  public void setBuyer(User buyer) {
    this.buyer = buyer;
  }

}
