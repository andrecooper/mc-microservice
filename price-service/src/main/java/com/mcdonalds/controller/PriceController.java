package com.mcdonalds.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@Slf4j
public class PriceController {

    @Value("${price.discount}")
    private double discount = 1.0;

    @RequestMapping("/price")
    @HystrixCommand(fallbackMethod = "getPricesFromCache")
    public Map<String, Double> getPrices() {
        log.info("Current discount: " + discount);

        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("burger", 15.8 * discount);
        priceMap.put("cola", 14.0 * discount);
        priceMap.put("muffin", 23.5 * discount);
        priceMap.put("frenchFires", 13.2 * discount);
        priceMap.put("nuggets", 25.0 * discount);

        if (Math.random() < 0.2) throw new NullPointerException("Huston we have a problem!!");
        return priceMap;
    }

    public Map<String, Double> getPricesFromCache() {
        return new HashMap<>();
    }
}
