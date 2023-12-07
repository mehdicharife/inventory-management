package ma.nemo.assignment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.ProductReturn;
import ma.nemo.assignment.repository.ProductReturnRepository;


@Service
public class ProductReturnServiceImpl implements ProductReturnService {

    private ProductReturnRepository productReturnRepository;
    private ProductModelService productModelService;
    private ProductService productService;

    public ProductReturnServiceImpl(ProductReturnRepository productReturnRepository, ProductModelService productModelService, ProductService productService) {
        this.productReturnRepository = productReturnRepository;
        this.productModelService = productModelService;
        this.productService = productService;
    }

    public Optional<ProductReturn> saveProductReturnWith(String productCode, long quantity, String returnReason) {
        Optional<ProductModel> optionaProductModel = this.productModelService.getProductModelByProductCode(productCode);
        if(!optionaProductModel.isPresent()) {
            return Optional.empty();
        }

        ProductReturn productReturn = new ProductReturn();
        productReturn.setProductModel(optionaProductModel.get());
        productReturn.setQuantity(quantity);
        productReturn.setReturnReason(returnReason);
        this.productReturnRepository.save(productReturn);

        this.productService.createProductWith(optionaProductModel.get(), quantity);

        return Optional.of(productReturn);
    }
    
    /*
    public Optional<ProductReturn> saveProductReturnWith(String productCode, long quantity, String returnReason) {
        Optional<ProductReturn> optionalProductReturn = this.saveProductReturnWith(productCode, quantity);
        if(!optionalProductReturn.isPresent()) {
            return Optional.empty();
        }

        ProductReturn productReturn = optionalProductReturn.get();
        productReturn.setReturnReason(returnReason);
        return Optional.of(this.productReturnRepository.save(productReturn));
    }
    */
}
