package com.flatiron.spring.flatironspring;
import com.flatiron.spring.flatironspring.BitcoinController;

import com.flatiron.spring.flatironspring.BitcoinService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BitcoinControllerUnitTest {
    /**
     * Test the controller to see if we are getting the correct response.
     */

    @Test
    void shouldReturnBitcoinPrice(){
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        String bitcoinPrice = "23000.00";
        BitcoinController bitcoinController = new BitcoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice()).thenReturn(bitcoinPrice);
        assertEquals(bitcoinPrice,bitcoinController.getBitcoinPrice(),
                "Controller returns the correct value");
    }

    @Test
    void shouldReturnCryptoPrice(){
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        String etherPrice = "13000.00";
        String currency = "ethereum";
        BitcoinController bitcoinController = new BitcoinController(bitcoinService);
        when(bitcoinService.getCurrencyPrice(currency)).thenReturn(etherPrice);
        assertEquals(etherPrice,bitcoinController.getCurrencyPrice(currency),
                "Controller returns the correct value");
    }


}
