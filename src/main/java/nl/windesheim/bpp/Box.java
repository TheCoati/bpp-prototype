package nl.windesheim.bpp;

import nl.windesheim.bpp.exceptions.BoxOverflowException;

import java.util.List;

/**
 * @param size The maximum weight the box can carry
 * @param products List of product to put inside the box
 */
public record Box(int size, List<Product> products) {
    /**
     * Calculate the total weight of the products already in the box
     * @return Sum of the total weight of the box
     */
    public int totalWeight() {
        return this.products.stream()
                .mapToInt(Product::weight)
                .sum();
    }

    /**
     * Calculates the remaining weight in the box
     * @return The remaining weight in the box
     */
    public int remainingWeight() {
        return this.size - this.totalWeight();
    }

    /**
     * Check if product can fit in the box
     * @param product Product to validate if it fits in the box
     * @return Boolean if the product fits in the box
     */
    public boolean fitsProduct(Product product) throws BoxOverflowException {
        return product.weight() <= this.remainingWeight();
    }
}
