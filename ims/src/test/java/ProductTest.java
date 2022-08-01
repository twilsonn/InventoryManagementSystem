import org.junit.jupiter.api.Test;
import org.tyler.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    void makeBlankProduct() {
        Product product = new Product();
        assertEquals(0, product.getId());
        assertNull(product.getName());
        assertNull(product.getColor());
        assertNull(product.getSize());
        assertEquals(0, product.getStock());
    }

    @Test
    void makeFullProduct() {
        Product product = new Product();
        product.setId(99);
        product.setName("TestProduct");
        product.setStock(99);
        product.setColor(Product.Color.WHITE);
        product.setSize(Product.Size.SMALL);

        assertAll("makeProduct",
                () -> assertEquals(99, product.getId()),
                () -> assertEquals(99, product.getStock()),
                () -> assertEquals("TestProduct", product.getName()),
                () -> assertEquals(Product.Color.WHITE, product.getColor()),
                () -> assertEquals(Product.Size.SMALL, product.getSize())
        );
    }
}
