package com.mcdonalds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PriceController {

    @RequestMapping("/price")
    public Map<String,Double> getPrices(){
        Map<String,Double> priceMap = new HashMap<>();
        priceMap.put("burger",15.8 );
        priceMap.put("cola", 14.0 );
        priceMap.put("muffin",23.5 );
        priceMap.put("frenchFires",13.2 );
        priceMap.put("nuiggets", 25.0 );

        return priceMap;
    }

}
