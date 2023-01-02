package com.prgms.springorder;

import com.prgms.springorder.order.Order;
import com.prgms.springorder.voucher.MemoryVoucherRepository;
import com.prgms.springorder.voucher.Voucher;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@Configurable
@ComponentScan(
        basePackages = {"com.prgms.springorder.order", "com.prgms.springorder.voucher", "com.prgms.springorder.configuration"}
        //basePackageClasses = {Order.class, Voucher.class}
)
//(excludeFilters = {@ComponentScan.Filter(type = ___)}) -> 특정클래스 제외하기
// excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MemoryVoucherRepository.class)}
class AppConfiguration {
    //다양한 Bean들이 특정 용도에 맞게 그룹화 되어 definition의 configuration file로 작성되어야 할 때 사용
}
