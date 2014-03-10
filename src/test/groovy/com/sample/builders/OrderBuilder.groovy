package com.sample.builders

import com.sample.Customer
import com.sample.LineItem
import com.sample.Order
import com.sample.testing.ARandom

class OrderBuilder {
    Order order

    OrderBuilder() {
        order = new Order()
        order.customer = Anonymous.customer.build()
        order.orderDate = ARandom.dateInPastMonth()
        order.lineItems = []
    }

    OrderBuilder with(LineItem lineItem) {
        order.addLineItem(lineItem)
        return this
    }

    OrderBuilder with(LineItemBuilder lineItemBuilder) {
        def lineItem = lineItemBuilder.build()
        return with(lineItem)
    }

    OrderBuilder forCustomer(Customer customer) {
        order.customer = customer
        return this
    }

    Order build() {
        return order
    }
}
