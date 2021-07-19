import utils.FileHandler;
import utils.Scanner;

public class StartTv {

    public static void main(String[] args) {

        /* returns the operating system's environment variables (in Map data structure)
        System.out.println(System.getenv());
         */

        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile("programmes.txt");


        Scanner.intScanner("Please enter a number for channel:");
        Scanner.strScanner("Please enter a title for a movie: ");

    }
}
