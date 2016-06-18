package com.mcdonalds.service;

import com.mcdonalds.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by abondar on 6/18/16.
 */

@Service
public class CashService {

    @Autowired
    RestTemplate restTemplate;

    public Map<String,Double> getMenu(){
//        Map<String,Double> priceMap = restTemplate.getForObject("http://localhost:8080/price", Map.class);
        Map<String,Double> priceMap = restTemplate.getForObject("http://price-service/price", Map.class);
        return priceMap;
    }

    public List<OrderItem> passToKitchen(Map<String, String> order) {
        Map<String, Double> menu = getMenu();
        List<OrderItem> orderList = new LinkedList<>();
        long orderId = System.currentTimeMillis();
        Date orderDate = new Date();
        order.entrySet().forEach(item -> {
            String product = item.getKey();
            Integer amount = Integer.valueOf(item.getValue());
            Double price = menu.get(product);
            orderList.add(
                    OrderItem.builder()
                            .orderId(orderId)
                            .orderDate(orderDate)
                            .amount(amount)
                            .price(price)
                            .productName(product)
                            .build());
        });
        return orderList;
    }

    public double getOrderTotal(List<OrderItem> orderItems) {
        return orderItems
                .stream()
                .mapToDouble(item -> item.getPrice() * item.getAmount())
                .sum();
    }

    public void saveReport(List<OrderItem> orderList){
//            restTemplate.postForLocation("http://localhost:8282/order",orderList);
            restTemplate.postForLocation("http://report-service/order",orderList);
    }


}
