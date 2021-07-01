package utils;


public class Scanner {


    private static java.util.Scanner getScanner() {
        return new java.util.Scanner(System.in);
    }

    public static String strScanner(String text) {
        System.out.println(text);
        return getScanner().nextLine();
    }

    public static int intScanner(String text) {
        System.out.println(text);
        return getScanner().nextInt();
    }
}
