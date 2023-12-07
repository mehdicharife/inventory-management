package ma.nemo.assignment.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.nemo.assignment.dto.ProductReturnDto;
import ma.nemo.assignment.service.ProductReturnService;
import ma.nemo.assignment.domain.ProductReturn;

@RestController
@RequestMapping("/api/return")
public class ProductReturnController {
    
    private ProductReturnService productReturnService;

    public ProductReturnController(ProductReturnService productReturnService) {
        this.productReturnService = productReturnService;
    }

    @PostMapping
    public ResponseEntity<ProductReturn> addProductReturn(@RequestBody ProductReturnDto productReturnDto) {
        Optional<ProductReturn> optionalProductReturn = this.productReturnService.saveProductReturnWith(
            productReturnDto.getProductCode(),
            productReturnDto.getQuantity(),
            productReturnDto.getReturnReason()
        );

        if(!optionalProductReturn.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ProductReturn>(optionalProductReturn.get(), HttpStatus.OK);
    }

    
}
