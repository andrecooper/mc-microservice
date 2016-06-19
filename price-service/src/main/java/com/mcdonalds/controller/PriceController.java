package com.mcdonalds.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PriceController{

    @Value("${price.discount}")
    private double discount = 1.0;

    @RequestMapping("/price")
    @HystrixCommand(fallbackMethod = "getPricesFromCache")
    public Map<String,Double> getPrices(){
        System.out.println("DISCOUNT: " + discount);

        Map<String,Double> priceMap = new HashMap<>();
        priceMap.put("burger",15.8 );
        priceMap.put("cola", 14.0 );
        priceMap.put("muffin",23.5 );
        priceMap.put("frenchFires",13.2 );
        priceMap.put("nuiggets", 25.0 );
        if (Math.random() < 0.2) throw new NullPointerException("Huston we have a problem!!");
        return priceMap;
    }

    public Map<String,Double> getPricesFromCache() {
        Map<String, Double> cachedPrices = new HashMap<>();
        return cachedPrices;
    }

}
