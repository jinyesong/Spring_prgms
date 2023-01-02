package com.prgms.springorder.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoucherService {
    //@Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    public VoucherService(@Qualifier("memory") VoucherRepository voucherRepository) {
        //Autowired가 default
        this.voucherRepository = voucherRepository;
    }

    public VoucherService(VoucherRepository voucherRepository, String dummy) {
        //생성자가 두개인 경우에는 Spring에 자동으로 주입이 되는 생성자에만 Autowired를 붙여야 함
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository.findById(voucherId).orElseThrow(()-> new RuntimeException("Can not find a voucher for "+ voucherId));
    }

    public void useVoucher(Voucher voucher) {
    }

//    @Autowired //setter를 통해서도 자동주입 가능
//    public void setVoucherRepository(VoucherRepository voucherRepository) {
//        this.voucherRepository = voucherRepository;
//    }
}
