package ma.nemo.assignment.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.repository.SupplyRepository;


@Service
public class SupplyServiceImpl implements SupplyService{
    
    private SupplyRepository supplyRepository;
    private ProductModelService productModelService;
    private ProductService productService;

    public SupplyServiceImpl(SupplyRepository supplyRepository, ProductModelService productModelService, ProductService productService) {
        this.supplyRepository = supplyRepository;
        this.productModelService = productModelService;
        this.productService = productService;
    }

    private Supply crudlyCreateSupplyWith(String productCode, Integer quantity, Date expirationDate) {
        ProductModel productModel;

        Optional<ProductModel> optionalProductModel = this.productModelService.getProductModelByProductCode(productCode);
        if(optionalProductModel.isPresent()) {
            productModel = optionalProductModel.get();
        } else {
            productModel = new ProductModel();
            productModel.setProductCode(productCode);
            this.productModelService.saveProductModel(productModel);
        }

        Supply supply = new Supply();
        supply.setQuantity(quantity);
        supply.setProductModel(productModel);
        supply.setExpirationDate(expirationDate);
        supply.setSupplyDate(new Date());

        return this.supplyRepository.save(supply);
    }


    public Optional<Supply> createSupplyWith(String productCode, Integer quantity) {
        if(quantity > 500) {
            return Optional.empty();
        }

        Supply supply = this.crudlyCreateSupplyWith(productCode, quantity, null);
        
        this.productService.createProductWith(supply.getProductModel(), quantity);
        
        return Optional.ofNullable(supply);
    }

    public Optional<Supply> createSupplyWith(String productCode, Integer quantity, Date expirationDate) {
        if(quantity > 500) {
            return Optional.empty();
        }

        Supply supply = this.crudlyCreateSupplyWith(productCode, quantity, expirationDate);
        
        this.productService.createProductWith(supply.getProductModel(), quantity, expirationDate);
        
        return Optional.ofNullable(supply);
    }

    
}
