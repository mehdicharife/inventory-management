package ma.nemo.assignment.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.dto.SupplyDto;
import ma.nemo.assignment.service.SupplyService;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    private SupplyService supplyService;
    
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }
    

    @PostMapping
    public ResponseEntity<Supply> addSupply(@RequestBody SupplyDto supplyDto) {
        Optional<Supply> optionalSupply;
        if(supplyDto.getExpirationDate() == null) {
            optionalSupply = this.supplyService.createSupplyWith(supplyDto.getProductCode(), supplyDto.getQuantity());
        } else {
            optionalSupply = this.supplyService.createSupplyWith(supplyDto.getProductCode(),
                supplyDto.getQuantity(),
                supplyDto.getExpirationDate()
            );
        }

        if(optionalSupply.isPresent()) {
            return new ResponseEntity<Supply>(optionalSupply.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}