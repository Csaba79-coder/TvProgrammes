package testExam.utils;

import testExam.enumerations.TypeOfUnitOfStudy;
import testExam.major.Major;

import java.util.ArrayList;
import java.util.List;

/**
 * Ebben az osztályban szeretném a stringlistákat tartalmazó stringlistámból létrehozni a példányokat.
 */

public class ObjectCreator {

    private List<Major> myMajors = new ArrayList<>();

    public ObjectCreator() {
        fillMajorList();
    }

    private Major makeOneMajor(List<String> stringList){

        Major major = new Major();

        major.setName(stringList.get(0));
        major.setCodeOfUnitOfStudy(stringList.get(1));
        major.setNameOfUnitOfStudy(stringList.get(2));

        if (stringList.get(3).equals("K")){
            major.setTypeOfUnitOfStudy(TypeOfUnitOfStudy.K);
        }else if(stringList.get(3).equals("G")){
            major.setTypeOfUnitOfStudy(TypeOfUnitOfStudy.G);
        }else if(stringList.get(3).equals("V")){
            major.setTypeOfUnitOfStudy(TypeOfUnitOfStudy.V);
        }else{
            major.setTypeOfUnitOfStudy(TypeOfUnitOfStudy.EF);
        }

        if(stringList.get(4).contains("|")){
            major.setRecommendedSemesters(semesterList(stringList.get(4)));
        }else{
            major.getRecommendedSemesters().add(Integer.parseInt(stringList.get(4)));
        }

        major.setRecommendedSemesters(semesterList(stringList.get(4)));
        major.setCredit(Integer.parseInt(stringList.get(5)));

        if (stringList.get(6).contains("|")){
            major.setPreconditions(preconditionsListList(stringList.get(6)));
        }else{
            major.getPreconditions().add(stringList.get(6));
        }

        if(stringList.get(6).contains("*")){
            major.setContainsWeakPreconditions(true);
        }else{
            major.setContainsWeakPreconditions(false);
        }

        return major;
    }

    public void fillMajorList(){
        DocReader docReader = new DocReader();
        for (int i = 0; i < docReader.getStringsForCreatingMajors().size(); i++) {
            myMajors.add(makeOneMajor(docReader.getStringsForCreatingMajors().get(i)));
        }
    }

    private List<Integer> semesterList(String string){

        List<Integer> myList = new ArrayList<>();

        String[] parts = string.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            myList.add(Integer.parseInt(parts[i]));
        }

        return myList;
    }

    private List<String> preconditionsListList(String string){

        List<String> myList = new ArrayList<>();

        String[] parts = string.split("\\|");
        for (int i = 0; i < parts.length; i++) {
            myList.add(parts[i]);
        }

        return myList;
    }

    public void showMajorList(){
        for (int i = 0; i < myMajors.size(); i++) {
            myMajors.get(i).showMyMajor();
        }
    }

    public List<Major> getMyMajors() {
        return myMajors;
    }

    public void setMyMajors(List<Major> myMajors) {
        this.myMajors = myMajors;
    }
}
