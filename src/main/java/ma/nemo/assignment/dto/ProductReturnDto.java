package ma.nemo.assignment.dto;

public class ProductReturnDto {

    private String productCode;
    
    private long quantity;

    private String returnReason;

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getReturnReason() {
        return this.returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
    
}
