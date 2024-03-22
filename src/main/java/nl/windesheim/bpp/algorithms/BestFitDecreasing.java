package nl.windesheim.bpp.algorithms;

import nl.windesheim.bpp.Box;
import nl.windesheim.bpp.Product;
import nl.windesheim.bpp.exceptions.BoxOverflowException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestFitDecreasing implements Algorithm {
    /**
     * @param products Product to sort in the algorithm
     * @param boxSize The size of the available boxes
     * @throws BoxOverflowException Throws exception when product is added that does not fit any box size
     * @return List of boxes filled with the products
     */
    @Override
    public List<Box> sort(List<Product> products, int boxSize) throws BoxOverflowException {
        // Sort products on weight
        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(Product::weight).reversed())
                .toList();

        List<Box> boxes = new ArrayList<>();

        for (Product product : sorted) {
            if (product.weight() > boxSize) {
                throw new BoxOverflowException(product);
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
}
