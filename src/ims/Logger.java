package ims;

public class Logger {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public Logger() {
    }

    public static void printError(String message) {
        System.out.println(ANSI_RED + "**********************************");
        System.out.println(ANSI_RED + "Error: " + message);
        System.out.println(ANSI_RED + "**********************************");
    }

    public static void printInfo(String message) {
        System.out.print(ANSI_BLUE + message);
    }
    public static void printInfoLn(String message) {
        System.out.println(ANSI_BLUE + message);
    }

    public static void printSuccess(String message) {
        System.out.println(ANSI_GREEN + "**********************************");
        System.out.println(ANSI_GREEN + "Success: " + message);
        System.out.println(ANSI_GREEN + "**********************************");
    }

    public static void log(String message) {
        System.out.print(ANSI_WHITE + message);
    }
    public static void logLn(String message) {
        System.out.println(ANSI_WHITE + message);
    }

    public static void br() {
        System.out.println(ANSI_WHITE + "==================================");
    }
}
