package com.example.SpringUnitTesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

    private BitCoinService bitCoinService;

    public PriceController(BitCoinService bitCoinService) {

        this.bitCoinService = bitCoinService;
    }

    @GetMapping("/bitcoin")
    public String price(@PathVariable String bitcoin) {
        return String.format("<h1>Hello User</h1>" +
                "Price of" + bitcoin+ "is currently: " + bitCoinService.getBitcoinPrice());

    }

}