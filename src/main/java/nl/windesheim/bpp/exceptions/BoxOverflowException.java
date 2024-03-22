package nl.windesheim.bpp.exceptions;

import nl.windesheim.bpp.Product;

public class BoxOverflowException extends Exception {
    public BoxOverflowException(Product product) {
        super("Product of size " + product.weight() + " could not be fitted in any available box size.");
    }
}
