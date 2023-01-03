package com.prgms.springorder.order;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;

@Component
public class OrderProperties implements InitializingBean {
    @Value("${springorder2.version : v0.0.0}") //콜론 이후의 값? 디폴트 값으로 만약 정의된 프로퍼티가 없을 경우 사용
    private String version;

    @Value("0")
    private int minimumOrderAmount;

    @Value("d, a, b")
    private List<String> supportVendors;

    @Value("${JAVA_HOME}") //$JAVA_HOME 자바 환경변수도 가능, 만약 프로퍼티의 이름이 같다면 환경변수의 우선순위가 더 높음
    private String javaHome;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(MessageFormat.format("[OrderProperties] version -> {0}", version));
        System.out.println(MessageFormat.format("[OrderProperties] minimumOrderAmount -> {0}", minimumOrderAmount));
        System.out.println(MessageFormat.format("[OrderProperties] supportVendors -> {0}", supportVendors));
        System.out.println(MessageFormat.format("[OrderProperties] javaHome -> {0}", javaHome));
    }
}
