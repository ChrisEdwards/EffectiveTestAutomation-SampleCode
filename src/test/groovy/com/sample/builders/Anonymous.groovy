package com.sample.builders

class Anonymous {
    static CustomerBuilder getCustomer() {
        return new CustomerBuilder()
    }

    static OrderBuilder getOrder() {
        return new OrderBuilder()
    }

    static LineItemBuilder getLineItem() {
        return new LineItemBuilder()
    }

    static ProductBuilder getProduct() {
        return new ProductBuilder()
    }
}
