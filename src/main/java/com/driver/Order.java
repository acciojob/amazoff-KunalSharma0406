package com.driver;

public class Order {
    private String orderId;
    private String deliveryTime;
    private String partnerId;

    public Order(String orderId, String deliveryTime, String partnerId) {
        this.orderId = orderId;
        this.deliveryTime = deliveryTime;
        this.partnerId = partnerId;
    }

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}

