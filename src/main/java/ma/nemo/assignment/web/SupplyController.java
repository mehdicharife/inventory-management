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
import ma.nemo.assignment.exceptions.SupplyLargerThan500Exception;
import ma.nemo.assignment.service.SupplyService;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {
    

    private SupplyService supplyService;
    
    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }
    

    @PostMapping
    public ResponseEntity<Object> addSupply(@RequestBody SupplyDto supplyDto) {
        try {
            Supply supply = this.supplyService.createSupplyWith(
                    supplyDto.getProductCode(), 
                    supplyDto.getQuantity(), 
                    supplyDto.getExpirationDate()
                );
            
            return new ResponseEntity<>(supply, HttpStatus.CREATED);
        } 

        catch(SupplyLargerThan500Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }
}