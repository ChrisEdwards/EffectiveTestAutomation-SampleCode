package com.sample.discounts

import com.sample.DiscountStrategy
import com.sample.Order

class DiscountCalculator {
    DiscountStrategy discountStrategy

    DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy
    }

    double calculateDiscount(Order order){
        double discountRate = discountStrategy.calculateDiscount(order.totalAmount)
        return order.totalAmount * discountRate
    }
}
