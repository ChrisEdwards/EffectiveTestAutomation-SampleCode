package com.sample

class LineItem {
    int id
    Order order
    Product product
    int quantity
    double unitPrice

    double getAmount() {
        return quantity * unitPrice
    }
}
