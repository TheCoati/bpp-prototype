package nl.windesheim.bpp.algorithms;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestFitDecreasingTest {
    private static final List<Product> products = new ArrayList<>();

    private static final Algorithm algorithm = new BestFitDecreasing();

    @BeforeAll
    public static void before() {
        // Fill test with example data
        products.add(new Product(1));
        products.add(new Product(1));
        products.add(new Product(3));
        products.add(new Product(3));
        products.add(new Product(5));
        products.add(new Product(5));
    }

    @Test
    void testSort() {
        // Result should always be equal no matter the order
        Collections.shuffle(products);

        List<Box> boxes = algorithm.sort(products, 6);

        // Sample output
        for (Box box : boxes) {
            System.out.println("--- BOX ---");

            for (Product product : box.products()) {
                System.out.println("Product: " + product.weight());
            }
        }

        System.out.println("------------");
        System.out.println("Filled " + products.size() + " products in " + boxes.size() + " boxes.");

        assertEquals(3, boxes.size());
    }
}
