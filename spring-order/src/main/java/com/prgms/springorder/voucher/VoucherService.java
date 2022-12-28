package com.prgms.springorder.voucher;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoucherService {
    public final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public Voucher getVoucher(UUID voucherId) {
        return voucherRepository.findById(voucherId).orElseThrow(()-> new RuntimeException("Can not find a voucher for "+ voucherId));
    }

    public void useVoucher(Voucher voucher) {
    }
}
