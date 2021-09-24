package testExam.utils;

import testExam.major.Major;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ebben az osztályban feltöltöm a forrásfile sorait stringekre szabdalva egy listába, és ezeket a listákat egy listába teszem.
 * A későbbiekben ebből fogom létrehozni a Major osztály példányait. Így könnyen tudom kezelni az adatokat, és egyes stringeket tovább szabdalni/vizsgálni.
 */

public class DocReader {

    private List<List<String>> stringsForCreatingMajors = new ArrayList<>();

    public DocReader() {
        loadAllData();
    }

    private void loadAllData() {
        try {
            String[] sources = {
                    FileRouting.getSourceMajor(),
            };
            for (String source : sources) {
                loadSingleList(source);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSingleList(String fileName) throws IOException {
        BufferedReader bufferedReader = loadFileToBufferedReader(fileName);
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            String[] parts = line.split(";");
            if (fileName.equals(FileRouting.getSourceMajor())) {
                List<String> stringList = new ArrayList<>();
                stringList.add(parts[0]);
                stringList.add(parts[1]);
                stringList.add(parts[2]);
                stringList.add(parts[3]);
                stringList.add(parts[4]);
                stringList.add(parts[5]);
                stringList.add(parts[6]);
                stringsForCreatingMajors.add(stringList);
            }
        }
    }

    private BufferedReader loadFileToBufferedReader(String fileName) throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        return  bufferedReader;
    }

    /**
     * Ellenőrzöm, hogy helyes-e a feltöltésem.
     */
    public void showMyLists(){
        for (int i = 0; i < stringsForCreatingMajors.size(); i++) {
            System.out.println(stringsForCreatingMajors.get(i));
        }
    }

    public List<List<String>> getStringsForCreatingMajors() {
        return stringsForCreatingMajors;
    }

    public void setStringsForCreatingMajors(List<List<String>> stringsForCreatingMajors) {
        this.stringsForCreatingMajors = stringsForCreatingMajors;
    }
}
