package com.tofu.vinlab.entities;

import java.util.List;

public class Order {
    private int id;

    private ClientId clientId;

    private Status status;

    private List<OrderItem> itemList;

    public Order(int id, ClientId clientId, List<OrderItem> itemList) {
        this.id = id;
        this.clientId = clientId;
        this.itemList = itemList;
        this.status = Status.CREATED;
    }

    public void buy() {
        try {
            for (OrderItem item : itemList) {
                var product = item.getProduct();
                product.buy(item.getQuantity());
            }
            this.status = Status.COMPLETED;
        } catch (Exception e) {
            System.out.println("Ошибка покупки для заказа " + id + ": " + e.getMessage());
            this.status = Status.FAILED;
        }
    }

    public void cancel() {
        this.status = Status.CANCELLED;
    }

    enum Status {
        CREATED,
        COMPLETED,
        CANCELLED,
        FAILED,
    }
}
