package ma.nemo.assignment.service;

import java.util.List;
import java.util.Optional;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductModelThreshold;


public interface ProductModelThresholdService {
    Optional<ProductModelThreshold> saveProdutModelThresholdWith(String productCode, Integer threshold);
    List<ProductModel> getProductModelsBelowThreshold();
}
