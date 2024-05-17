package nl.windesheim.bpp.examples;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import nl.windesheim.bpp.algorithms.BPPResolver;
import nl.windesheim.bpp.algorithms.BestFitDecreasingResolver;

import java.util.*;

public class BestFitDecreasingRandom {
    /**
     * The available weights of the products
     */
    private static final int[] PRODUCT_WEIGHTS = new int[]{1, 3, 5};

    /**
     * The size of the boxes to fill
     */
    private static final int BOX_SIZE = 6;

    /**
     * Amount of products to generate in the test
     */
    private static final int PRODUCTS = 100;

    public static void main(String[] args) {
        List<Product> products = getRandomProducts();
        BPPResolver algorithm = new BestFitDecreasingResolver();

        List<Box> boxes = algorithm.sort(products, BOX_SIZE);

        // Sample output
        for (Box box : boxes) {
            System.out.println("- - - BOX - - -");

            for (Product product : box.products()) {
                System.out.println("Product: " + product.weight());
            }
        }

        System.out.println("- - - - - - - -");
        System.out.println("Filled " + products.size() + " products in " + boxes.size() + " boxes.");
    }

    /**
     * Generate a random orders with random products in random order
     * @return List of random products in random order
     */
    private static List<Product> getRandomProducts() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < BestFitDecreasingRandom.PRODUCTS; i++) {
            int weightIndex = random.nextInt(BestFitDecreasingRandom.PRODUCT_WEIGHTS.length);

            products.add(new Product(BestFitDecreasingRandom.PRODUCT_WEIGHTS[weightIndex]));
        }

        // Shuffle the order
        Collections.shuffle(products);

        return products;
    }
}
