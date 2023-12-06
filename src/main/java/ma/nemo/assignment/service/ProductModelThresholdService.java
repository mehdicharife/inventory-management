package ma.nemo.assignment.service;

import java.util.Optional;

import ma.nemo.assignment.domain.ProductModelThreshold;


public interface ProductModelThresholdService {
    Optional<ProductModelThreshold> saveProdutModelThresholdWith(String productCode, Integer threshold);
}
