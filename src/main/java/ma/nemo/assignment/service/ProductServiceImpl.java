package ma.nemo.assignment.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
    
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProductWith(ProductModel productModel, long quantity) {
        Product product = new Product();

        product.setProductModel(productModel);
        product.setQuantity(quantity);

        return this.productRepository.save(product);
    }

    public Product createProductWith(ProductModel productModel, long quantity, Date expirationDate) {
        Product product = new Product();

        product.setProductModel(productModel);
        product.setQuantity(quantity);
        product.setExpirationDate(expirationDate);

        return this.productRepository.save(product);
    }

    public List<Product> getNearingExpirationDateProducts() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 15);
        return this.productRepository.findByExpirationDateBefore(calendar.getTime());
    }

    public long getProductsQuantitySumByProductModel(ProductModel productModel) {
        return this.productRepository.sumQuantityByProductModel(productModel);
    }

    public long getProductsQuantitySumByProductCode(String productCode) {
        return this.productRepository.sumQuantityByProductCode(productCode);
    }
    

    public void reduceQuantityByProductCode(String productCode, long quantity) {
        long quantityInStock = this.getProductsQuantitySumByProductCode(productCode);
        if(quantity > quantityInStock) {
            return;
        }
        
        List<Product> products = this.productRepository.findAllByOrderByExpirationDateAsc();
        long reducedQuantity = 0;
        for(Product product : products) {
            if(reducedQuantity == quantity) {
                break;
            }
            long currentProductQuantity = product.getQuantity();
            long currentReducedQuantity = Math.min(currentProductQuantity, quantity - reducedQuantity);
            product.setQuantity(currentProductQuantity - currentReducedQuantity);
            this.productRepository.save(product);

            reducedQuantity += currentReducedQuantity;
        }
    }

    
}
