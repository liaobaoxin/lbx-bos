package com.lbx.domain;

import java.math.BigDecimal;

public class Orderitems extends OrderitemsKey {
    private String prodId;

    private Integer quantity;

    private BigDecimal itemPrice;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId == null ? null : prodId.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Orderitems{" +
                "prodId='" + prodId + '\'' +
                ", quantity=" + quantity +
                ", itemPrice=" + itemPrice +
                "} " + super.toString();
    }
}