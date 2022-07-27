package ims;

import java.util.Scanner;

public class Utils {
    Scanner scanner;

    Utils(Scanner scanner) {
        this.scanner = scanner;
    }
    protected int getInput() {
        String inputString = this.scanner.nextLine();
        try {
            return Integer.parseInt(inputString);
        } catch (Exception e) {
            return 8;
        }
    }

    protected String getInputString() {
        return this.scanner.nextLine();
    }
}