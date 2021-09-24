package testExam.utils;

public class FileRouting {

    private static final String SOURCE_DIR = "src/resources/";
    private static final String SOURCE_MAJOR= SOURCE_DIR + "szakok.txt";

    public FileRouting() {
    }

    public static String getSourceDir() {
        return SOURCE_DIR;
    }

    public static String getSourceMajor() {
        return SOURCE_MAJOR;
    }
}
