package nl.windesheim.bpp.algorithms;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BestFitDecreasingResolver implements BPPResolver {
    private static final ExecutorService THREAD = Executors.newCachedThreadPool();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Box> sort(List<Product> products, int boxSize) {
        // Sort products on weight
        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(Product::weight).reversed())
                .toList();

        List<Box> boxes = new ArrayList<>();

        for (Product product : sorted) {
            if (product.weight() > boxSize) {
                return new ArrayList<>();
            }

            fit: {
                for (Box box : boxes) {
                    if (box.fitsProduct(product)) {
                        box.products().add(product);
                        break fit; // Fit in box and goto next product
                    }
                }

                // Put product in a new box
                Box box = new Box(boxSize, new ArrayList<>());
                box.products().add(product);
                boxes.add(box);
            }
        }

        return boxes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompletableFuture<List<Box>> sortAsync(List<Product> products, int boxSize) {
        CompletableFuture<List<Box>> future = new CompletableFuture<>();

        THREAD.submit(() -> {
            future.complete(this.sort(products, boxSize));
        });

        return future;
    }
}
