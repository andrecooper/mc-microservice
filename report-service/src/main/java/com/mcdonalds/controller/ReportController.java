package com.mcdonalds.controller;

import com.mcdonalds.model.OrderItem;
import com.mcdonalds.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by abondar on 6/18/16.
 */

@RestController
@Slf4j
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public void storeReport(@RequestBody List<OrderItem> orderItemList){
        log.info("Accepted order: " + orderItemList);
        reportRepository.save(orderItemList);
    }
}
