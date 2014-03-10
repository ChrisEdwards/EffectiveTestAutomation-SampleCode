package com.sample.builders

import com.sample.Product
import com.sample.testing.ARandom

class ProductBuilder {
    Product product

    ProductBuilder() {
        product = new Product()
        product.name = ARandom.text(20)
        product.description = ARandom.text(100)
    }

    Product build() {
        return product
    }
}
