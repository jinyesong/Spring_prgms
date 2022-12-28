package com.prgms.springorder;

import com.prgms.springorder.order.Order;
import com.prgms.springorder.voucher.MemoryVoucherRepository;
import com.prgms.springorder.voucher.Voucher;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Configurable
@ComponentScan(
        basePackageClasses = {Order.class, Voucher.class}
)
//(basePackages = {"com.prgms.springorder.order", "com.prgms.springorder.voucher"}
//(excludeFilters = {@ComponentScan.Filter(type = ___)}) -> 특정클래스 제외하기
// excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MemoryVoucherRepository.class)}
class AppConfiguration {
    
}
