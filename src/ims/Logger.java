package ims;

public class Logger {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Logger() {
    }

    static void printError(String message) {
        System.out.println(ANSI_RED + "**********************************");
        System.out.println(ANSI_RED + "Error: " + message);
        System.out.println(ANSI_RED + "**********************************");
    }

    static void printInfo(String message) {
        System.out.print(ANSI_BLUE + message);
    }
    static void printInfoLn(String message) {
        System.out.println(ANSI_BLUE + message);
    }

    static void printSuccess(String message) {
        System.out.println(ANSI_GREEN + "**********************************");
        System.out.println(ANSI_GREEN + "Success: " + message);
        System.out.println(ANSI_GREEN + "**********************************");
    }

    static void log(String message) {
        System.out.print(ANSI_WHITE + message);
    }
    static void logLn(String message) {
        System.out.println(ANSI_WHITE + message);
    }

    static void br() {
        System.out.println(ANSI_WHITE + "==================================");
    }
}
