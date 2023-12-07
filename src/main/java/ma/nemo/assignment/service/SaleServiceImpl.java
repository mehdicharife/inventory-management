package ma.nemo.assignment.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import ma.nemo.assignment.repository.SaleRepository;
import ma.nemo.assignment.domain.Sale;


@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private ProductService productService;
    private ProductModelService productModelService;

    public SaleServiceImpl(SaleRepository saleRepository, ProductService productService, ProductModelService productModelService) {
        this.saleRepository = saleRepository;
        this.productService = productService;
        this.productModelService = productModelService;
    }


    
    public Optional<Sale> addSaleWith(String productCode, long quantity) {
        if(quantity <= 0) {
            return Optional.empty();
        }
        long productCount = this.productService.getProductsQuantitySumByProductCode(productCode);
        if(productCount < quantity) {
            return Optional.empty();
        }

        Sale newSale = new Sale();
        newSale.setProductModel(this.productModelService.getProductModelByProductCode(productCode).get());
        newSale.setQuantity(quantity);
        this.saleRepository.save(newSale);
        this.productService.reduceQuantityByProductCode(productCode, quantity);
        

        return Optional.of(newSale);
    }
}
