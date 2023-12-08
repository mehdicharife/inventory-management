package ma.nemo.assignment.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.exceptions.SupplyLargerThan500Exception;
import ma.nemo.assignment.exceptions.SupplyNegativeQuantityException;
import ma.nemo.assignment.factories.SupplyFactory;
import ma.nemo.assignment.repository.SupplyRepository;


@Service
public class SupplyServiceImpl implements SupplyService{
    
    private SupplyRepository supplyRepository;
    private ProductModelService productModelService;
    private ProductService productService;
    private SupplyFactory supplyFactory;


    public SupplyServiceImpl(SupplyRepository supplyRepository, ProductModelService productModelService, ProductService productService, SupplyFactory supplyFactory) {
        this.supplyRepository = supplyRepository;
        this.productModelService = productModelService;
        this.productService = productService;
        this.supplyFactory = supplyFactory;
    }


    public Supply createSupplyWith(String productCode, Integer quantity, Date expirationDate) throws SupplyLargerThan500Exception, SupplyNegativeQuantityException {
        if(quantity > 500) {
            throw new SupplyLargerThan500Exception("Supply quantity is larger than 500");
        }

        if(quantity <= 0) {
            throw new SupplyNegativeQuantityException("Supply quantity is negative");
        }

        ProductModel productModel = this.productModelService.getOrCreateProductModelByProductCode(productCode);

        Supply supply = supplyFactory.createSupplyWith(productModel, quantity, expirationDate, new Date());
        supply = this.supplyRepository.save(supply);

                
        this.productService.createProductWith(productModel, quantity, expirationDate);
        
        return supply;
    }

    
}
