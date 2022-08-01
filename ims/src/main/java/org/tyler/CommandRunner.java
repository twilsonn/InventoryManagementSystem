package org.tyler;

import java.util.Arrays;
import java.util.List;

public class CommandRunner {
    private final Utils utils;
    private final Inventory inventory;
    static final private List<Product.Color> colors = Arrays.asList(Product.Color.values());
    static final private List<Product.Size> sizes = Arrays.asList(Product.Size.values());
    public CommandRunner(Utils utils, Inventory inventory) {
        this.utils = utils;
        this.inventory = inventory;
    }
    protected boolean getProductInfo() {
        // display product info
        Logger.br();
        Logger.log("Input ID: ");
        Product product = inventory.getProduct(utils.getInput());
        if(product == null) {
            Logger.printError("Product does not exist");
            return false;
        }
        Logger.printSuccess(product.toString());
        return true;
    }
    protected boolean addProduct() {
        // add new product
        Logger.br();
        Product newProduct = new Product();
        Logger.printInfo("Input ID: ");
        newProduct.setId(this.utils.getInput());
        Logger.printInfo("Input Name: ");
        newProduct.setName(this.utils.getInputString());


        Logger.printInfoLn("Input Color: ");
        // Print available colors
        for (int i = 0; i < colors.size(); i++) {
            Logger.logLn(i + 1 + ") " + colors.get(i));
        }
        newProduct.setColor(colors.get(this.utils.getInput() - 1));

        Logger.printInfoLn("Input Size: ");
        // Print available sizes
        for (int i = 0; i < sizes.size(); i++) {
            Logger.logLn(i + 1 + ") " + sizes.get(i));
        }
        newProduct.setSize(sizes.get(this.utils.getInput() - 1 ));

        Logger.printInfo("Input stock: ");
        newProduct.setStock(this.utils.getInput());

        if (!inventory.addProduct(newProduct, false)) {
            Logger.printError("Product with ID already exists");
            Logger.printInfoLn("Do you want to override this product?");
            Logger.logLn("1) YES");
            Logger.logLn("2) NO");
            if (this.utils.getInput() == 1) {
                inventory.addProduct(newProduct, true);
                return true;
            }
            return false;
        }

        Logger.printSuccess("product added");
        return true;
    }
    protected boolean removeProduct() {
        // remove product
        Logger.br();
        Logger.printInfo("Input ID: ");

        Product productToDelete = inventory.getProduct(utils.getInput());
        if (productToDelete == null) {
            Logger.printError("Product does not exist");
            return false;
        }

        Logger.printInfoLn("Are you sure you want to delete the following product?");
        Logger.logLn("1) YES");
        Logger.logLn("2) NO");

        if (utils.getInput() == 1) {
            inventory.removeProduct(productToDelete.getId());
            Logger.printSuccess("Product deleted");
            return true;
        }

        Logger.printSuccess("Product deletion cancelled");
        return true;
    }
    protected boolean updateProduct() {
        // update product field
        Logger.br();
        Logger.log("Input ID: ");
        Product updateProduct = inventory.getProduct(utils.getInput());
        if(updateProduct == null) {
            Logger.printError("Product does not exist");
            return false;
        }
        Logger.logLn(updateProduct.toString());
        Logger.printInfoLn("What field do you want to update?");
        Logger.logLn("1) Name");
        Logger.logLn("2) Color");
        Logger.logLn("3) Size");
        Logger.logLn("4) Stock");

        switch (utils.getInput()) {
            case 1:
                Logger.log("Input Name: ");
                updateProduct.setName(utils.getInputString());
                inventory.updateProduct(updateProduct);
                break;
            case 2:
                Logger.printInfoLn("Input Color: ");
                // Print available colors
                for (int i = 0; i < colors.size(); i++) {
                    Logger.logLn(i + 1 + ") " + colors.get(i));
                }
                updateProduct.setColor(colors.get(utils.getInput() - 1));
                inventory.updateProduct(updateProduct);
                break;
            case 3:
                Logger.printInfoLn("Input Size: ");
                // Print available sizes
                for (int i = 0; i < sizes.size(); i++) {
                    Logger.logLn(i + 1 + ") " + sizes.get(i));
                }
                updateProduct.setSize(sizes.get(utils.getInput() - 1 ));

                inventory.updateProduct(updateProduct);
                break;
            case 4:
                Logger.printInfoLn("Input Stock: ");
                updateProduct.setStock(utils.getInput());
                inventory.updateProduct(updateProduct);
                break;
            default:
                Logger.printError("action cancelled");
                return false;
        }

        return true;
    }
    protected boolean getProductStock() {
        // get product stock
        Logger.br();
        Logger.log("Input ID: ");
        Product product = inventory.getProduct(utils.getInput());
        if(product == null) {
            Logger.printError("Product does not exist");
            return false;
        }
        Logger.printSuccess(String.valueOf(product.getStock()));
        return true;
    }
}
