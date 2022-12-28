package com.prgms.springorder.order;

import com.prgms.springorder.order.Order;
import com.prgms.springorder.order.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryOrderRepository implements OrderRepository {
    private final Map<UUID, Order> storage = new ConcurrentHashMap<>();
    @Override
    public Order insert(Order order) {
        storage.put(order.getOrderid(), order);
        return order;
    }
}
