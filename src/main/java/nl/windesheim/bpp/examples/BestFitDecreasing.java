package nl.windesheim.bpp.examples;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import nl.windesheim.bpp.algorithms.BPPResolver;
import nl.windesheim.bpp.algorithms.BestFitDecreasingResolver;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BestFitDecreasing {
    public static void main(String[] args) {
        int maxBoxSize = 6;

        List<Product> data = List.of(
            new Product(1),
            new Product(1),
            new Product(3),
            new Product(3),
            new Product(5)
        );

        BPPResolver resolver = new BestFitDecreasingResolver();

        // Blocking example
        List<Box> resultSync = resolver.sort(data, maxBoxSize);

        System.out.println(resultSync);

        // Non-blocking example
        CompletableFuture<List<Box>> future = resolver.sortAsync(data, maxBoxSize);

        future.thenAccept(resultAsync -> {
            System.out.println(resultAsync);
        });
    }
}
