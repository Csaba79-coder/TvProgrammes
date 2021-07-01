package utils;

import java.io.IOException;
// import org.springframework.beans.factory.annotation.Value;


public class FileHandler {

//    public void readFile(String txt) {
//        String sourceDirectory = "src/resources/";
//        String fileName = sourceDirectory + txt;
//        try {
//            Reader.buffer(fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    @Value("${sourceDirectory}") // with different kind of environment/project can work!

    private final String sourceDirectory = "src/resources/";

    public void readFile(String txt) {
        String fileName = sourceDirectory + txt;
        try {
            Reader.buffer(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
