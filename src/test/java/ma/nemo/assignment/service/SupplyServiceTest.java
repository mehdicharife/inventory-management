package ma.nemo.assignment.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;
import static org.mockito.ArgumentMatchers.*;

import java.util.Date;

import ma.nemo.assignment.domain.ProductModel;
import ma.nemo.assignment.domain.Supply;
import ma.nemo.assignment.exceptions.SupplyLargerThan500Exception;
import ma.nemo.assignment.exceptions.SupplyNegativeQuantityException;
import ma.nemo.assignment.factories.SupplyFactory;
import ma.nemo.assignment.repository.SupplyRepository;



@ExtendWith(MockitoExtension.class) 
public class SupplyServiceTest  {

    @InjectMocks
    private SupplyServiceImpl supplyService;

    @Mock
    private SupplyRepository supplyRepository;

    @Mock
    private ProductModelService productModelService;

    @Mock
    private ProductService productService;

    @Mock
    private SupplyFactory supplyFactory;



    @Test
    public void shouldThrowSupplyLargerthan500ExceptionWhenSupplyIsLargerThan500() throws Exception {

        Assertions.assertThrowsExactly(SupplyLargerThan500Exception.class, 
            () -> this.supplyService.createSupplyWith("test-code", 600, null)
        );        

    }

    @Test
    public void shouldThrowSupplyNegativeQuantityExceptionWhenQuantityIsNegative() throws Exception {
        Assertions.assertThrowsExactly(SupplyNegativeQuantityException.class, 
            () -> this.supplyService.createSupplyWith("test-code", -12 , null)
        );          
    }

    @Test
    public void verifyThatProductModelCorrespondingToProductCodeIsGettedOrCreated() throws Exception{
        String productCode = "test-code";


        this.supplyService.createSupplyWith(productCode, 20, null);


        Mockito.verify(this.productModelService).getOrCreateProductModelByProductCode(productCode);
    }


    
    @Test
    public void verifyThatSupplyIsCreatedWithCorrectProductModel() throws Exception {
        String productCode = "test-code";
        Integer quantity = 20;
        ProductModel productModel = new ProductModel(productCode);

        Mockito.when(productModelService.getOrCreateProductModelByProductCode(productCode))
            .thenReturn(productModel);


        this.supplyService.createSupplyWith(productCode, quantity, null);

        Mockito.verify(supplyFactory).createSupplyWith(Mockito.eq(productModel), any(Integer.class), isNull(), any(Date.class));
    }

    
    @Test
    public void verifyThatSupplyRepositoryIsPassedCreatedSupply() throws Exception {
        String productCode = "test-code";
        Integer quantity = 20;
        
        ProductModel productModel = new ProductModel(productCode);
        Supply supply = new Supply(productModel, quantity);      

        Mockito.when(productModelService.getOrCreateProductModelByProductCode(productCode))
            .thenReturn(productModel);

        Mockito
            .lenient()
            .when(this.supplyFactory.createSupplyWith(any(ProductModel.class), any(Integer.class), isNull(), any(Date.class)))
            .thenReturn(supply);

        this.supplyService.createSupplyWith(productCode, quantity, null);

        Mockito.verify(supplyRepository).save(Mockito.eq(supply));
    }


    @Test
    public void verifyThatProductIsCreatedWithCorrectAttributes() throws Exception {
        String productCode = "test-code";
        Integer quantity = 20;
        Date expirationDate = null;

        ProductModel productModel = new ProductModel(productCode);


        Mockito.when(this.productModelService.getOrCreateProductModelByProductCode(productCode))
            .thenReturn(productModel);

        this.supplyService.createSupplyWith(productCode, quantity, expirationDate);

        Mockito.verify(this.productService).createProductWith(productModel, quantity, expirationDate);

    }
    
}
