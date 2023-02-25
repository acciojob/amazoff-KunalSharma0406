package com.driver;

import java.util.List;

public class DeliveryPartner {
    private String partnerId;
    private List<String> assignedOrderIds;

    public DeliveryPartner(String partnerId, List<String> assignedOrderIds) {
        this.partnerId = partnerId;
        this.assignedOrderIds = assignedOrderIds;
    }

    // Getters and Setters

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public List<String> getAssignedOrderIds() {
        return assignedOrderIds;
    }

    public void setAssignedOrderIds(List<String> assignedOrderIds) {
        this.assignedOrderIds = assignedOrderIds;
    }
}
