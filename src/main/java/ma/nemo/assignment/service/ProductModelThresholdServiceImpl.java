package ma.nemo.assignment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductModelThreshold;
import ma.nemo.assignment.repository.ProductModelThresholdRepository;



@Service
public class ProductModelThresholdServiceImpl implements ProductModelThresholdService {
    private ProductModelThresholdRepository productModelThresholdRepository;
    private ProductModelService productModelService;

    public ProductModelThresholdServiceImpl(ProductModelThresholdRepository productModelThresholdRepository, ProductModelService productModelService) {
        this.productModelThresholdRepository = productModelThresholdRepository;
        this.productModelService = productModelService;
    }
    
    public Optional<ProductModelThreshold> saveProdutModelThresholdWith(String productCode, Integer threshold) {
        Optional<ProductModel> optionalProductModel = this.productModelService.getProductModelByProductCode(productCode);
        if(!optionalProductModel.isPresent()) {
            return Optional.empty();
        }
        
        ProductModelThreshold productModelThreshold = new ProductModelThreshold();
        productModelThreshold.setProductModel(optionalProductModel.get());
        productModelThreshold.setThreshold(threshold);

        return Optional.ofNullable(this.productModelThresholdRepository.save(productModelThreshold));
    }
}
