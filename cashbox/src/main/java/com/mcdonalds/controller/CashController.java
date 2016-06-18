package com.mcdonalds.controller;

import com.mcdonalds.model.OrderItem;
import com.mcdonalds.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CashController {

    @Autowired
    CashService cashService;


    @RequestMapping("/menu")
    public Map<String,Double> getMenu(){
        return cashService.getMenu();
    }

    @RequestMapping(value = "/menu/{order}", method = RequestMethod.POST)
    public double makeOrder(@RequestParam Map<String, String> order){
        order.entrySet().forEach(System.out::println);

        List<OrderItem> orderItems = cashService.passToKitchen(order);
        cashService.saveReport(orderItems);
        return cashService.getOrderTotal(orderItems);
    }

}
