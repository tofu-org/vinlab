package com.tofu.vinlab.entities.client;

public class ClientId {
    private long value;

    public ClientId(long clientId) {
        this.value = clientId;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
