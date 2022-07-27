package ims;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Inventory inventory = new Inventory();

    private static final Utils utils = new Utils(scanner);

    public static void main(String[] args) {
        runApp();
    }

    static void runApp() {
        CommandRunner cmd = new CommandRunner(utils, inventory);
        int command;
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

            String inputString = null;
            command = utils.getInput();

            switch (command) {
                case 1:
                    if (cmd.getProductInfo()) {
                        break;
                    }
                    break;
                case 2:
                    if (cmd.addProduct()) {
                        break;
                    }
                    break;
                case 3:
                    if (cmd.removeProduct()) {
                        break;
                    }
                    break;
                case 4:
                    if (cmd.updateProduct()) {
                        break;
                    }
                    break;
                case 5:
                    // display product stock
                    if (cmd.getProductStock()) {
                        break;
                    }
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
