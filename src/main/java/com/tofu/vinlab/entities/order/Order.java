package com.tofu.vinlab.entities.order;

import java.util.List;
import java.util.logging.Logger;

import com.tofu.vinlab.Main;
import com.tofu.vinlab.entities.client.ClientId;

public class Order {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private Integer id;

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
            logger.warning("Ошибка покупки для заказа " + id + ": " + e.getMessage());
            this.status = Status.FAILED;
        }
    }

    public void cancel() {
        this.status = Status.CANCELLED;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void addIterm(OrderItem item) {
        this.itemList.add(item);
    }

    public enum Status {
        CREATED,
        COMPLETED,
        CANCELLED,
        FAILED,
    }
}
