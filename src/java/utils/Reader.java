package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Reader {

    public static void buffer(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            System.out.println(line);
        }
    }
}
