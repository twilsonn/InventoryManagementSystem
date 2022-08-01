package org.tyler;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Inventory {
    private final HashMap<Integer, Product> products;

    public Inventory(@NotNull HashMap<Integer, Product> products) {
        this.products = products;
    }

    /**
     * @param id product id
     * @return returns product or null
     */
    public Product getProduct(int id) {
        return products.get(id);
    }

    /**
     * @param product product object to add
     * @param override if true, product will override existing ID.
     * @return
     * returns true if product addition is successful
     * returns false if there is a conflict with an existing product ID
     */
    public boolean addProduct(@NotNull Product product, boolean override) {
        // if override is not enabled and product ID exists in map, return false
        if (!override && products.containsKey(product.getId())) {
            return false;
        }

        // add product to inventory
        products.put(product.getId(), product);
        return true;
    }

    /**
     * @param id product id
     * @return true if remove was successful
     */
    public boolean removeProduct(int id) {
        if (!products.containsKey(id)) {
            return false;
        }

        products.remove(id);
        return true;
    }

    /**
     * @param product product object to update
     * @return true if update was successful
     */
    public boolean updateProduct(@NotNull Product product) {
        if (!products.containsKey(product.getId())) {
            return false;
        }

        products.put(product.getId(), product);
        return true;
    }
}
