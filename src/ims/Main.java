package ims;

import sun.awt.OSInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        commandRunner();
    }

    static List<Product.Color> colors = Arrays.asList(Product.Color.values());
    static List<Product.Size> sizes = Arrays.asList(Product.Size.values());

    static int getInput() {
        String inputString = scanner.nextLine();
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            return 8;
        }
    }

    static String getInputString() {
        return scanner.nextLine();
    }

    static void commandRunner() {
        Integer command = null;
        Integer input = null;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // print instructions
            Logger.br();
            Logger.logLn("Please select an option:");
            Logger.logLn("1. Display product info");
            Logger.logLn("2. Add product");
            Logger.logLn("3. Delete product");
            Logger.logLn("4. Update product");
            Logger.logLn("5. Check product stock");
            Logger.logLn("6. Exit");
            Logger.br();

            String commandString = scanner.nextLine();
            String inputString = null;

            try {
                command = Integer.parseInt(commandString);
            } catch (Exception e) {
                continue;
            }

            switch (command) {
                case 1:
                    // display product info
                    Logger.br();
                    Logger.log("Input ID: ");
                    Product product = inventory.getProduct(getInput());
                    if(product == null) {
                        Logger.printError("Product does not exist");
                        break;
                    }
                    Logger.printSuccess(product.toString());
                    break;
                case 2:
                    // add new product
                    Logger.br();
                    Product newProduct = new Product();
                    Logger.printInfo("Input ID: ");
                    newProduct.setId(getInput());
                    Logger.printInfo("Input Name: ");
                    newProduct.setName(getInputString());


                    Logger.printInfoLn("Input Color: ");
                    // Print available colors
                    for (int i = 0; i < colors.size(); i++) {
                        Logger.logLn(i + 1 + ") " + String.valueOf(colors.get(i)));
                    }
                    newProduct.setColor(colors.get(getInput() - 1));

                    Logger.printInfoLn("Input Size: ");
                    // Print available sizes
                    for (int i = 0; i < sizes.size(); i++) {
                        Logger.logLn(i + 1 + ") " + String.valueOf(sizes.get(i)));
                    }
                    newProduct.setSize(sizes.get(getInput() - 1 ));

                    Logger.printInfo("Input stock: ");
                    newProduct.setStock(getInput());

                    if (!inventory.addProduct(newProduct, false)) {
                        Logger.printError("Product with ID already exists");
                        Logger.printInfoLn("Do you want to override this product?");
                        Logger.logLn("1) YES");
                        Logger.logLn("2) NO");
                        if (getInput() == 1) {
                            inventory.addProduct(newProduct, true);
                        }
                        break;
                    }

                    Logger.printSuccess("product added");
                    break;
                case 3:
                    // remove product
                    Logger.br();
                    Logger.printInfo("Input ID: ");

                    Product productToDelete = inventory.getProduct(getInput());
                    if (productToDelete == null) {
                        Logger.printError("Product does not exist");
                        break;
                    }

                    Logger.printInfoLn("Are you sure you want to delete the following product?");
                    Logger.logLn("1) YES");
                    Logger.logLn("2) NO");

                    if (getInput() == 1) {
                        inventory.removeProduct(productToDelete.getId());
                        Logger.printSuccess("Product deleted");
                        break;
                    }

                    Logger.printSuccess("Product deletion cancelled");

                    break;
                case 4:
                    // update product field
                    Logger.br();
                    Logger.log("Input ID: ");
                    Product updateProduct = inventory.getProduct(getInput());
                    if(updateProduct == null) {
                        Logger.printError("Product does not exist");
                        break;
                    }
                    Logger.logLn(updateProduct.toString());
                    Logger.printInfoLn("What field do you want to update?");
                    Logger.logLn("1) Name");
                    Logger.logLn("2) Color");
                    Logger.logLn("3) Size");
                    Logger.logLn("4) Stock");

                    switch (getInput()) {
                        case 1:
                            Logger.log("Input Name: ");
                            updateProduct.setName(getInputString());
                            inventory.updateProduct(updateProduct);
                            break;
                        case 2:
                            Logger.printInfoLn("Input Color: ");
                            // Print available colors
                            for (int i = 0; i < colors.size(); i++) {
                                Logger.logLn(i + 1 + ") " + String.valueOf(colors.get(i)));
                            }
                            updateProduct.setColor(colors.get(getInput() - 1));
                            inventory.updateProduct(updateProduct);
                            break;
                        case 3:
                            Logger.printInfoLn("Input Size: ");
                            // Print available sizes
                            for (int i = 0; i < sizes.size(); i++) {
                                Logger.logLn(i + 1 + ") " + String.valueOf(sizes.get(i)));
                            }
                            updateProduct.setSize(sizes.get(getInput() - 1 ));

                            inventory.updateProduct(updateProduct);
                            break;
                        case 4:
                            Logger.printInfoLn("Input Stock: ");
                            updateProduct.setStock(getInput());
                            inventory.updateProduct(updateProduct);
                            break;
                        default:
                            Logger.printError("action cancelled");
                            break;
                    }

                    break;
                case 5:
                    // display product stock
                    break;
                case 6:
                case 8:
                    break;
                default:
                    Logger.printError("action cancelled");
                    break;
            }
        }
        while (command != 6);
    }
}
