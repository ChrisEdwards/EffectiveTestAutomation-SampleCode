package com.sample

import org.joda.time.LocalDate

class Order {
    int id
    Customer customer
    LocalDate orderDate
    List<LineItem> lineItems = []

    double getTotalAmount() {
        return lineItems.collect { it.amount }.sum() as double
    }

    LineItem addLineItem(LineItem lineItem) {
        lineItem.order = this
        lineItems << lineItem
        return lineItem
    }
}
