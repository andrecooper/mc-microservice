package com.mcdonalds.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderItem {

    private long id;
    private long orderId;
    private Date orderDate;
    private String productName;
    private int amount;
    private double price;
}
