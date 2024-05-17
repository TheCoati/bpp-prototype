package nl.windesheim.bpp.algorithms;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BPPResolver {
    /**
     * Execute the bin packing problem algorithm
     * @param products Product to sort in the algorithm
     * @param boxSize The size of the available boxes
     * @return List of boxes filled with the products
     */
    List<Box> sort(List<Product> products, int boxSize);

    /**
     * Execute the bin packing problem algorithm async
     * @param products Product to sort in the algorithm
     * @param boxSize The size of the available boxes
     * @return List of boxes filled with the products
     */
    CompletableFuture<List<Box>> sortAsync(List<Product> products, int boxSize);
}
