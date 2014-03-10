package com.sample.discounts

import com.sample.DiscountStrategy

class TieredDiscountStrategy implements DiscountStrategy {
    List<DiscountTier> tiers = []

    TieredDiscountStrategy(List<DiscountTier> tiers) {
        this.tiers = tiers
    }

    @Override
    double calculateDiscount(double totalAmount) {
        def sortedTiers = tiers.sort { it.minQualifyingAmount }

        // Default tier has zero discount
        def maxDiscountTier = new DiscountTier(minQualifyingAmount: 0.0, discountPercentage: 0.0)

        // Find max discount tier
        sortedTiers.each { tier ->
            if (totalAmount >= tier.minQualifyingAmount)
                maxDiscountTier = tier
        }
        return maxDiscountTier.discountPercentage
    }
}
