package utilities;

/**
 * The type Printer.
 */
public class Printer {


    /**
     * Print.
     *
     * @param message the message
     */
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * Print seperator.
     */
    public static void printSeperator  () {
        System.out.println("-----------------------");
    }

    /**
     * Print red.
     *
     * @param message the message
     */
    public static void printRed(String message) {
        System.out.println("\033[31m" + message +"\033[0m");
    }

    /**
     * Print green.
     *
     * @param message the message
     */
    public static void printGreen(String message) {
        System.out.println("\033[32m" + message +"\033[0m");
    }

    /**
     * Print error.
     *
     * @param message the message
     */
    public static void printError(String message) {
        System.err.println("⚠ Fehler: " + message);

    }

}
