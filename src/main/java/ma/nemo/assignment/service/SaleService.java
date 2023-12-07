package ma.nemo.assignment.service;

import java.util.Optional;
import ma.nemo.assignment.domain.Sale;

public interface SaleService {

    Optional<Sale> addSaleWith(String productCode, long quantity);
}
