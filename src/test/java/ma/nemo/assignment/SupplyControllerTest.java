package ma.nemo.assignment;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.nemo.assignment.dto.SupplyDto;
import ma.nemo.assignment.service.SupplyService;
import ma.nemo.assignment.web.SupplyController;


@WebMvcTest(SupplyController.class)
public class SupplyControllerTest {
/*
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplyService supplyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldCallSupplyAddWithTwoArgumentsWhenDtoDoesntContainExpirationDate() throws Exception {
        SupplyDto supplyDto = new SupplyDto("TestSupply", 200);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/supply")
            .content(objectMapper.writeValueAsString(supplyDto))
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder);

        verify(supplyService).createSupplyWith(supplyDto.getProductCode(), supplyDto.getQuantity(), new Date());
    }

    */
}
