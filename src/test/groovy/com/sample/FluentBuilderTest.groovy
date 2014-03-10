package com.sample

import com.sample.builders.Anonymous
import org.joda.time.LocalDate
import spock.lang.Specification

class FluentBuilderTest extends Specification {

    def "Without FluentBuilders"() {
        given:
        // LineItem1 = 1 qty @ $1.60
        def product1 = new Product(
                name: "Product 1 Name",
                description: "Product 1 Description"
        )
        def lineItem1 = new LineItem(
                product: product1,
                quantity: 1,
                unitPrice: 1.60
        )

        // LineItem2 = 10 qty @ $25.99
        def product2 = new Product(
                name: "Product 2 Name",
                description: "Product 2 Description"
        )
        def lineItem2 = new LineItem(
                product: product2,
                quantity: 10,
                unitPrice: 25.99
        )

        // Create order (gotta have customer first though)
        def customer = new Customer(
                firstName: "Bob",
                lastName: "Smith"
        )
        def order = new Order(
                customer: customer,
                orderDate: LocalDate.now()
        )
        order.addLineItem(lineItem1)
        order.addLineItem(lineItem2)

        when:
        def actualTotal = order.totalAmount

        then:
        assert actualTotal == (1 * 1.60) + (10 * 25.99)
    }

    def "With FluentBuilders"() {
        given:
        def order = Anonymous.order
                        .with( Anonymous.lineItem.costing(1.60) )
                        .with( Anonymous.lineItem.withQuantity(10).costing(25.99) )
                        .build()

        when:
        def actualTotal = order.totalAmount

        then:
        assert actualTotal == (1 * 1.60) + (10 * 25.99)
    }

}
