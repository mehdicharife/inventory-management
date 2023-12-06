package ma.nemo.assignment.service;

import java.util.Date;
import java.util.Optional;

import ma.nemo.assignment.domain.Supply;

public interface SupplyService {

    public Optional<Supply> createSupplyWith(String productCode, Integer quantity);
    public Optional<Supply> createSupplyWith(String productCode, Integer quantity, Date expirationDate);
}
