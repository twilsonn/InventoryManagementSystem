package ims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<Integer, Product>();
    }

    Product getProduct(int id) {
        return products.get(id);
    }

    /**
     * @param product
     * @param override
     * @return
     * returns true if product addition is successful
     * returns false if there is a conflict with an existing product ID
     */
    boolean addProduct(Product product, boolean override) {
        // if override is not enabled and product ID exists in map, return false
        if (!override && products.containsKey(product.getId())) {
            return false;
        }

        // add product to inventory
        products.put(product.getId(), product);
        return true;
    }

    /**
     * @param id
     * @return true if remove was successful
     */
    boolean removeProduct(int id) {
        if (!products.containsKey(id)) {
            return false;
        }

        products.remove(id);
        return true;
    }

    /**
     * @param product
     * @return true if update was successful
     */
    boolean updateProduct(Product product) {
        if (!products.containsKey(product.getId())) {
            return false;
        }

        products.put(product.getId(), product);
        return true;
    }
}
