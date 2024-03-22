package nl.windesheim.bpp.examples;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import nl.windesheim.bpp.algorithms.Algorithm;
import nl.windesheim.bpp.algorithms.BestFitDecreasing;
import nl.windesheim.bpp.exceptions.BoxOverflowException;

import java.util.*;

public class BestFitDecreasingExample {
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
    private static final int PRODUCTS = 10;

    public static void main(String[] args) {
        List<Product> products = getRandomProducts();
        Algorithm algorithm = new BestFitDecreasing();

        try {
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
        } catch (BoxOverflowException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a random orders with random products in random order
     * @return List of random products in random order
     */
    private static List<Product> getRandomProducts() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < BestFitDecreasingExample.PRODUCTS; i++) {
            int weightIndex = random.nextInt(BestFitDecreasingExample.PRODUCT_WEIGHTS.length);

            products.add(new Product(BestFitDecreasingExample.PRODUCT_WEIGHTS[weightIndex]));
        }

        // Shuffle the order
        Collections.shuffle(products);

        return products;
    }
}
