package ma.nemo.assignment.dto;

public class ProductModelThresholdDto {
    
    private String productCode;

    private Integer threshold;

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
}
