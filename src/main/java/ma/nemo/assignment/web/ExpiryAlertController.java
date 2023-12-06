package ma.nemo.assignment.web;
import ma.nemo.assignment.domain.Product;
import ma.nemo.assignment.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expiry-alerts")
public class ExpiryAlertController {

    private ProductService productService;

    public ExpiryAlertController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public List<Product> getNearingExpirationDateProducts() {
        return this.productService.getNearingExpirationDateProducts();
    }
}
