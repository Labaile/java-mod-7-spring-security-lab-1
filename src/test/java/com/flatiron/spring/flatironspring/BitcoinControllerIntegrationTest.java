package com.flatiron.spring.flatironspring;
import com.flatiron.spring.flatironspring.BitcoinController;
import com.flatiron.spring.flatironspring.BitcoinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BitcoinController.class)
public class BitcoinControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BitcoinService bitcoinService;
    /**
     * Test the endpoint to see if are getting a  response
     * @throws Exception
     */
    @WithMockUser(username = "fakeuser", authorities = "admin")
    @Test
    void getBitcoinPrice() throws Exception {
        mockMvc.perform(get("/coingecko"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @WithMockUser(username = "fakeuser", authorities = "admin")
    @Test
    void getCryptoPrice() throws Exception {
        mockMvc.perform(get("/coingecko/ethereum"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
