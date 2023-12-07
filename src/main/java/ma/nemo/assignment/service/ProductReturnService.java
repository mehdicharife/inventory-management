package ma.nemo.assignment.service;

import java.util.Optional;

import ma.nemo.assignment.domain.ProductReturn;

public interface ProductReturnService {
    //Optional<ProductReturn> saveProductReturnWith(String productCode, long quantity);
    Optional<ProductReturn> saveProductReturnWith(String productCode, long quantity, String returnReason);
}
