package ma.nemo.assignment.web;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.nemo.assignment.domain.ProductModelThreshold;
import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.dto.ProductModelThresholdDto;
import ma.nemo.assignment.service.ProductModelThresholdService;

@RestController
public class ProductModelThresholdController {
    private ProductModelThresholdService productModelThresholdService;

    public ProductModelThresholdController(ProductModelThresholdService productModelThresholdService) {
        this.productModelThresholdService = productModelThresholdService;
    }

    @PostMapping("/api/set-threshold")
    public ResponseEntity<ProductModelThreshold> setProductModelThreshold(@RequestBody ProductModelThresholdDto productModelThresholdDto) {

        Optional<ProductModelThreshold> optionalProductModelThreshold =  this.productModelThresholdService.saveProdutModelThresholdWith(
            productModelThresholdDto.getProductCode(),
            productModelThresholdDto.getThreshold()
        );

        if(optionalProductModelThreshold.isPresent()) {
            return new ResponseEntity<ProductModelThreshold>(optionalProductModelThreshold.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/threshold-alerts")
    public List<ProductModel> getProductModelsBelowThreshold() {
        return this.productModelThresholdService.getProductModelsBelowThreshold();
    }

    
}
