package nl.windesheim.bpp.exceptions;

import nl.windesheim.bpp.Product;

public class BoxOverflowException extends Exception {
    /**
     * @param product The product causing the box to overload
     */
    public BoxOverflowException(Product product) {
        super("Product of size " + product.weight() + " could not be fitted in any available box size.");
    }
}
