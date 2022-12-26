package com.prgms.springorder;

import java.util.UUID;

public class OrderItem { //JAVA14부터 record 사용해서 간단하게 표현가능
    public final UUID productId;
    public final long productPrice;
    public final int quantity;

    public OrderItem(UUID productId, long productPrice, int quantity) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public UUID getProductId() {
        return productId;
    }
}
