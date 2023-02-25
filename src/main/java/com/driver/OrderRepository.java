package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private Map<String, Order> ordersMap;
    private Map<String, DeliveryPartner> partnersMap;
    private Map<String, List<String>> unassignedOrdersMap;
    private Map<String, String> lastDeliveryTimeMap;

    public OrderRepository() {
        ordersMap = new HashMap<>();
        partnersMap = new HashMap<>();
        unassignedOrdersMap = new HashMap<>();
        lastDeliveryTimeMap = new HashMap<>();
    }

    public void addOrder(Order order) {
        ordersMap.put(order.getOrderId(), order);
        if (order.getPartnerId() == null) {
            if (!unassignedOrdersMap.containsKey(order.getDeliveryTime())) {
                unassignedOrdersMap.put(order.getDeliveryTime(), new ArrayList<>());
            }
            unassignedOrdersMap.get(order.getDeliveryTime()).add(order.getOrderId());
        } else {
            partnersMap.get(order.getPartnerId()).addOrderId(order.getOrderId());
            lastDeliveryTimeMap.put(order.getPartnerId(), order.getDeliveryTime());
        }
    }

    public void addDeliveryPartner(DeliveryPartner partner) {
        partnersMap.put(partner.getPartnerId(), partner);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        Order order = ordersMap.get(orderId);
        DeliveryPartner partner = partnersMap.get(partnerId);
        if (order.getPartnerId() != null) {
            partnersMap.get(order.getPartnerId()).removeOrderId(orderId);
        } else {
            unassignedOrdersMap.get(order.getDeliveryTime()).remove(orderId);
        }
        order.setPartnerId(partnerId);
        partner.addOrderId(orderId);
        lastDeliveryTimeMap.put(partnerId, order.getDeliveryTime());
    }

    public Order getOrderById(String orderId) {
        return ordersMap.get(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return partnersMap.get(partnerId);
    }

    public int getOrderCountByPartnerId(String partnerId) {
        return partnersMap.get(partnerId).getOrderIds().size();
    }

    public List<Order> getOrdersByPartnerId(String partnerId) {
        List<Order> orders = new


//    public int getOrdersLeftAfterGivenTimeByPartnerId(String partnerId, String time) {
//        DeliveryPartner partner = partnerMap.get(partnerId);
//        int count = 0;
//        for (String orderId

