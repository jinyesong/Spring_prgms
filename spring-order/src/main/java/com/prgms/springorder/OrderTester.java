package com.prgms.springorder;

import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

public class OrderTester {
    public static void main(String[] args) {
        var customerId = UUID.randomUUID();
        var orderContext = new OrderContext();
        var orderService = orderContext.orderService();
        var order = orderService.createOrder(customerId, new ArrayList<OrderItem> (){{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }});
        Assert.isTrue(order.totalAmount() == 100L, MessageFormat.format("totalAmount {0} is not 100L", order.totalAmount()));
    }
}