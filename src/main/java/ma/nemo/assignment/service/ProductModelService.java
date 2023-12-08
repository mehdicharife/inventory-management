package ma.nemo.assignment.service;

import java.util.List;
import java.util.Optional;

import ma.nemo.assignment.domain.ProductModel;

public interface ProductModelService {
    List<ProductModel> getAllProductModels();
    
    Optional<ProductModel> getProductModelByProductCode(String code);
    
    ProductModel saveProductModel(ProductModel productModel);

    ProductModel getOrCreateProductModelByProductCode(String productCode);

}
