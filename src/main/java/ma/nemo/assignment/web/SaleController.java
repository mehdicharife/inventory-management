package ma.nemo.assignment.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.nemo.assignment.domain.Sale;
import ma.nemo.assignment.dto.SaleDto;
import ma.nemo.assignment.service.SaleService;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    
    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<Sale> addNewSale(@RequestBody SaleDto saleDto) {
        Optional<Sale> optionalSale = this.saleService.addSaleWith(saleDto.getProductCode(), saleDto.getQuantity());
        if(!optionalSale.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Sale>(optionalSale.get(), HttpStatus.OK);
    }
    
}
