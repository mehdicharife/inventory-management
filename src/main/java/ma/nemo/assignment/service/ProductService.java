package ma.nemo.assignment.service;

import java.util.Date;
import java.util.List;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.domain.ProductModel;

public interface ProductService {
    Product createProductWith(ProductModel productModel, long quantity);

    Product createProductWith(ProductModel productModel, long quantity, Date expirationDate);

    List<Product> getNearingExpirationDateProducts();

    long getProductsQuantitySumByProductModel(ProductModel productModel);

    long getProductsQuantitySumByProductCode(String productCode);

    void reduceQuantityByProductCode(String productCode, long quantity);

}
