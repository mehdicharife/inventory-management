package ma.nemo.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductModelThreshold;
import ma.nemo.assignment.repository.ProductModelThresholdRepository;



@Service
public class ProductModelThresholdServiceImpl implements ProductModelThresholdService {
    private ProductModelThresholdRepository productModelThresholdRepository;
    private ProductModelService productModelService;
    private ProductService productService;

    public ProductModelThresholdServiceImpl(ProductModelThresholdRepository productModelThresholdRepository, ProductModelService productModelService, ProductService productService) {
        this.productModelThresholdRepository = productModelThresholdRepository;
        this.productModelService = productModelService;
        this.productService = productService;
    }
    
    public Optional<ProductModelThreshold> saveProdutModelThresholdWith(String productCode, Integer threshold) {
        Optional<ProductModel> optionalProductModel = this.productModelService.getProductModelByProductCode(productCode);
        if(!optionalProductModel.isPresent()) {
            return Optional.empty();
        }
        
        ProductModel productModel = optionalProductModel.get();
        ProductModelThreshold productModelThreshold = this.productModelThresholdRepository.findByProductModel(productModel).orElse(new ProductModelThreshold(productModel));
        productModelThreshold.setThreshold(threshold);

        return Optional.ofNullable(this.productModelThresholdRepository.save(productModelThreshold));
    }

    public List<ProductModel> getProductModelsBelowThreshold() {
        List<ProductModel> productModels = this.productModelService.getAllProductModels();
        
        for(int i = 0; i < productModels.size(); i++) {
            Optional<ProductModelThreshold> optionalProductModelThreshold =  this.productModelThresholdRepository.findByProductModel(productModels.get(i));
            if(!optionalProductModelThreshold.isPresent()) {
                productModels.remove(i);
                continue;
            }
            ProductModelThreshold currentProductModelThreshold = optionalProductModelThreshold.get();
            long currentProductModelMinimum = currentProductModelThreshold.getThreshold();
            long currentProductModelQuantity = this.productService.getProductsQuantitySumByProductModel(currentProductModelThreshold.getProductModel());
            if(currentProductModelQuantity > currentProductModelMinimum) {
                productModels.remove(i);
            }
        }   

        return productModels;
    }
}
