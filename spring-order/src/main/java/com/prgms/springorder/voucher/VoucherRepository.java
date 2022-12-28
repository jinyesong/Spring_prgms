package com.prgms.springorder.voucher;

import java.util.Optional;
import java.util.UUID;

public interface VoucherRepository { //보관하는 내용 및 형식이 어떨지 모르기 때문에 Repository는 대부분 interface로 정의
    Optional<Voucher> findById(UUID voucherId);
    Voucher insert(Voucher voucher);
}
