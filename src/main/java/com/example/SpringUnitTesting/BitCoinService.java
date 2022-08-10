package com.example.SpringUnitTesting;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BitCoinService {

    public String getBitcoinPrice() {
        String apiURL = "https://api.coincap.io/v2/assets/bitcoin";
        RestTemplate restTemplate = new RestTemplate();
        Data result = restTemplate.getForObject(apiURL, Data.class);
        double price = Double.parseDouble(result.getData().getPriceUsd());
        return String.format("$%.2f", price);
    }
}

@Getter
@Setter
class BitCoin {
    private String id;
    private String symbol;
    private String priceUsd;
}

@Getter
@Setter
class Data{
    private BitCoin data;
}