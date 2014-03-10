package com.sample.builders

import com.sample.LineItem
import com.sample.Product
import com.sample.testing.ARandom

class LineItemBuilder {
    LineItem lineItem

    LineItemBuilder() {
        lineItem = new LineItem()
        lineItem.unitPrice = ARandom.currencyAmountBetween(1, 1000)
        lineItem.quantity = 1
        lineItem.product = Anonymous.product.build()
        lineItem.order = Anonymous.order.build()
    }

    LineItemBuilder forProduct(Product product) {
        lineItem.product = product
        return this
    }

    LineItemBuilder costing(double unitPrice) {
        return withUnitPrice(unitPrice)
    }

    LineItemBuilder withUnitPrice(double unitPrice) {
        lineItem.unitPrice = unitPrice
        return this
    }

    LineItemBuilder withQuantity(int howMany) {
        lineItem.quantity = howMany
        return this
    }

    LineItem build() {
        return lineItem
    }
}
