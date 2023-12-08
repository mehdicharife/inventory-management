package ma.nemo.assignment.factories;

import java.util.Date;

import org.springframework.stereotype.Component;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.Supply;

@Component
public class SupplyFactory {

    public Supply createSupply() {
        return new Supply();
    }

    public Supply createSupplyWith(ProductModel productModel, Integer quantity) {
        Supply supply = new Supply();
        supply.setProductModel(productModel);
        supply.setQuantity(quantity);

        return supply;
    }

    public Supply createSupplyWith(ProductModel productModel, Integer quantity, Date expirationDate) {
        Supply supply = createSupplyWith(productModel, quantity);
        supply.setExpirationDate(expirationDate);
        return supply;
    }

    public Supply createSupplyWith(ProductModel productModel, Integer quantity, Date expirationDate, Date supplyDate) {
        Supply supply = createSupplyWith(productModel, quantity, expirationDate);
        supply.setSupplyDate(supplyDate);
        return supply;
    }
    
}
