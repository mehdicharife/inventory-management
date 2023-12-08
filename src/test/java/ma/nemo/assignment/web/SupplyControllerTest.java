package ma.nemo.assignment.web;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ma.nemo.assignment.dto.SupplyDto;
import ma.nemo.assignment.exceptions.SupplyLargerThan500Exception;
import ma.nemo.assignment.service.SupplyService;
import ma.nemo.assignment.web.SupplyController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.ArgumentMatchers.*;


@WebMvcTest(SupplyController.class)
public class SupplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplyService supplyService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldSendBadRequestStatusCodeWhenServiceThrowsSupplyLargerThan500Exception() throws Exception {
        SupplyDto supplyDto = new SupplyDto();
        
        Mockito.doThrow(new SupplyLargerThan500Exception()).when(supplyService).createSupplyWith(
            eq(supplyDto.getProductCode()), eq(supplyDto.getQuantity()), eq(supplyDto.getExpirationDate())
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/supply")
            .content(objectMapper.writeValueAsString(supplyDto))
            .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
            .andExpect(status().isBadRequest());
    }

    
}
