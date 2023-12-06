package ma.nemo.assignment.service;

import java.util.Optional;

import ma.nemo.assignment.domain.ProductModel;

public interface ProductModelService {
    Optional<ProductModel> getProductModelByProductCode(String code);
    
    ProductModel saveProductModel(ProductModel productModel);

}
