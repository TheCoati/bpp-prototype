package nl.windesheim.bpp.algorithms;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import nl.windesheim.bpp.exceptions.BoxOverflowException;

import java.util.List;

public interface Algorithm {
    /**
     * Execute the bin packing problem algorithm
     * @param products Product to sort in the algorithm
     * @param boxSize The size of the available boxes
     * @return List of boxes filled with the products
     */
    List<Box> sort(List<Product> products, int boxSize) throws BoxOverflowException;
}
