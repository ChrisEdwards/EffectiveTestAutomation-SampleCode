package com.sample.builders

import com.sample.Customer
import com.sample.testing.ARandom

class CustomerBuilder {
    Customer customer

    CustomerBuilder() {
        customer = new Customer()
        customer.firstName = ARandom.firstName()
        customer.lastName = ARandom.lastName()
    }

    Customer build() {
        return customer
    }
}
