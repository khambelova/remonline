package com.example.habik.lineservice.OrderStatus;

public class OrderInfo {

    private int count;

    private boolean success;

    private int page;

    private OrderDetails [] data;

    public boolean isSuccess() {
        return success;
    }

    public int getCount() {
        return count;
    }

    public int getPage() {
        return page;
    }

    public OrderDetails[] getData() {
        return data;
    }
}
