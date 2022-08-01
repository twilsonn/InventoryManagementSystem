import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tyler.Inventory;
import org.tyler.Product;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private final Inventory inv;
    private final Product product = new Product();

    InventoryTest () {
        HashMap<Integer, Product> products = new HashMap<>();
        inv = new Inventory(products);
        product.setId(99);
        product.setName("TestProduct");
        product.setStock(99);
        product.setColor(Product.Color.WHITE);
        product.setSize(Product.Size.SMALL);
    }

    @Test
    @DisplayName("addProduct without conflict")
    void addProductWithoutConflict() {
        boolean addProduct = inv.addProduct(product, false);
        assertTrue(addProduct);
    }

    @Test
    @DisplayName("addProduct with conflict")
    void addProductWithConflict() {
        inv.addProduct(product, true);
        boolean addProduct = inv.addProduct(product, false);
        assertFalse(addProduct);
    }

    @Test
    @DisplayName("addProduct with conflict override")
    void addProductWithConflictOverride() {
        inv.addProduct(product, false);
        boolean addProduct = inv.addProduct(product, true);
        assertTrue(addProduct);
    }

    @Test
    @DisplayName("getProduct when product doesn't exist")
    void getProductNonExistent() {
        Product getProduct = inv.getProduct(1);
        assertNull(getProduct);
    }

    @Test
    @DisplayName("getProduct when product exists")
    void getProduct() {
        inv.addProduct(product, false);
        Product getProduct = inv.getProduct(99);
        assertEquals(product, getProduct);
    }

    @Test
    @DisplayName("removeProduct product exists")
    void removeProduct() {
        assertTrue(inv.addProduct(product, false));
        boolean removeProduct = inv.removeProduct(99);
        assertTrue(removeProduct);
    }

    @Test
    @DisplayName("removeProduct product doesn't exist")
    void removeProductNonExistent() {
        boolean removeProduct = inv.removeProduct(1);
        assertFalse(removeProduct);
    }

    @Test
    @DisplayName("updateProduct when exists")
    void updateProduct() {
        assertTrue(inv.addProduct(product, false));

        Product updatedProduct = new Product();
        updatedProduct.setId(99);
        updatedProduct.setName("UpdatedProduct");
        updatedProduct.setStock(98);
        updatedProduct.setColor(Product.Color.BLACK);
        updatedProduct.setSize(Product.Size.LARGE);

        boolean updateProduct = inv.updateProduct(updatedProduct);
        assertTrue(updateProduct);

        assertEquals(updatedProduct, inv.getProduct(99));
    }

    @Test
    @DisplayName("updateProduct when doesn't exist")
    void updateProductNonExistent() {
        boolean removeProduct = inv.removeProduct(1);
        assertFalse(removeProduct);
    }
}
