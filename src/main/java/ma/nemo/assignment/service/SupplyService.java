package ma.nemo.assignment.service;

import java.util.Date;

import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.exceptions.SupplyLargerThan500Exception;

public interface SupplyService {

    //public Optional<Supply> createSupplyWith(String productCode, Integer quantity);
    public Supply createSupplyWith(String productCode, Integer quantity, Date expirationDate) throws SupplyLargerThan500Exception;
}
