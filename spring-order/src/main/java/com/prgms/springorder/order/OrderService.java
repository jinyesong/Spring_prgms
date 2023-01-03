package com.prgms.springorder.order;

import com.prgms.springorder.configuration.VersionProvider;
import com.prgms.springorder.voucher.VoucherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService { //Voucher를 활용하여 Order 생성
    private final VoucherService voucherService;
    private final OrderRepository orderRepository;

    public OrderService(VoucherService voucherService, OrderRepository orderRepository) {
        this.voucherService = voucherService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems){
        var order = new Order(UUID.randomUUID(), customerId, orderItems);
        return orderRepository.insert(order);

    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId){
        var voucher = voucherService.getVoucher(voucherId);
        var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.useVoucher(voucher);
        return order;

    }
}
