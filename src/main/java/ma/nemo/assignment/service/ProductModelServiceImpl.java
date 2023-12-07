package ma.nemo.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.repository.ProductModelRepository;

@Service
public class ProductModelServiceImpl implements ProductModelService {
    private ProductModelRepository productModelRepository;

    public List<ProductModel> getAllProductModels() {
        return this.productModelRepository.findAll();
    }

    public ProductModelServiceImpl(ProductModelRepository productModelRepository) {
        this.productModelRepository = productModelRepository;
    }


    public Optional<ProductModel> getProductModelByProductCode(String productCode) {
        return this.productModelRepository.findByProductCode(productCode);
    }

    public ProductModel saveProductModel(ProductModel productModel) {
        return this.productModelRepository.save(productModel);
    }
}
