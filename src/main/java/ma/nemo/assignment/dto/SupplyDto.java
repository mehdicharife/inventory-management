package ma.nemo.assignment.dto;

import java.util.Date;

public class SupplyDto {
    private Long id;
    private String productCode;
    private Integer quantity;
    private Date expirationDate;

    public SupplyDto() {

    }

    public SupplyDto(String productCode, Integer quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setExpirationDate(Date date) {
        this.expirationDate = date;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }
}
