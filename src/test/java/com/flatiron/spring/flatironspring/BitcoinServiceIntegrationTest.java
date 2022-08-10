package com.flatiron.spring.flatironspring;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BitcoinServiceIntegrationTest {
    @Test
    void shouldReturnBitcoinPrice() {
        BitcoinService bitcoinService = new BitcoinService();
        String bitcoinPrice = bitcoinService.getBitcoinPrice();
        assertThat(bitcoinPrice).isNotNull();
//        String bitcoinPrice2 = coinCapService.getBitcoinPrice();
//        assertThat(bitcoinPrice2).isNotNull();
//        assertThat(bitcoinPrice).isNotEqualTo(bitcoinPrice2);
    }

    @Test
    void shouldReturnEtherPrices(){
        String currency = "ethereum";
        BitcoinService bitcoinService = new BitcoinService();
        String cryptoPrice = bitcoinService.getCurrencyPrice(currency);
        assertThat(cryptoPrice).isNotNull();
    }
}
