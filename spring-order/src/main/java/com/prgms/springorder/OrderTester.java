package com.prgms.springorder;

import com.prgms.springorder.order.OrderItem;
import com.prgms.springorder.order.OrderService;
import com.prgms.springorder.voucher.FixedAmountVoucher;
import com.prgms.springorder.voucher.VoucherRepository;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;
import org.thymeleaf.standard.expression.MessageExpression;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTester {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        var environment = applicationContext.getEnvironment();
        var version = environment.getProperty("springorder.version");
        var minimumOrderAmount = environment.getProperty("springorder.minimum-order-amount", Integer.class);
        var supportVendors = environment.getProperty("springorder.support-vendors", List.class);
        System.out.println(MessageFormat.format("version -> {0}", version));
        System.out.println(MessageFormat.format("minimumOrderAmount -> {0}", minimumOrderAmount));
        System.out.println(MessageFormat.format("supportVendors -> {0}", supportVendors));


        var customerId = UUID.randomUUID();

        var voucherRepository = BeanFactoryAnnotationUtils.qualifiedBeanOfType(applicationContext.getBeanFactory(), VoucherRepository.class, "memory");
        var voucherRepository2 = BeanFactoryAnnotationUtils.qualifiedBeanOfType(applicationContext.getBeanFactory(), VoucherRepository.class, "memory");
        System.out.println(MessageFormat.format("voucherRepository {0}", voucherRepository));
        System.out.println(MessageFormat.format("voucherRepository2 {0}", voucherRepository2));
        System.out.println(MessageFormat.format("voucherRepository == voucherRepository2 => {0}", voucherRepository == voucherRepository2));
        //applicationContext.getBean(VoucherRepository.class); -> x
        //bean을 가져올 때도 두개 이상이라면 자동주입할 bean을 지정해주어야 함
        var voucher = voucherRepository.insert(new FixedAmountVoucher(UUID.randomUUID(), 10L));

        var orderService = applicationContext.getBean(OrderService.class);
        var order = orderService.createOrder(customerId, new ArrayList<OrderItem> (){{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }}, voucher.getVoucherId());

        Assert.isTrue(order.totalAmount() == 90L, MessageFormat.format("totalAmount {0} is not 90L", order.totalAmount()));

        applicationContext.close();
    }
}
