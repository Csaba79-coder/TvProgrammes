package testExam.major;

import testExam.enumerations.TypeOfUnitOfStudy;

import java.util.ArrayList;
import java.util.List;

public class Major {

    private String name;
    private String codeOfUnitOfStudy;
    private String nameOfUnitOfStudy;
    private TypeOfUnitOfStudy typeOfUnitOfStudy;
    private List<Integer> recommendedSemesters = new ArrayList<>();
    private int credit;
    private List<String> preconditions = new ArrayList<>();
    private boolean containsWeakPreconditions;

    public Major() {
    }

    public void showMyMajor(){
        System.out.println("name: " + name);
        System.out.println("codeOfUnitOfStudy: " + codeOfUnitOfStudy);
        System.out.println("nameOfUnitOfStudy: " + nameOfUnitOfStudy);
        System.out.println("typeOfUnitOfStudy: " + typeOfUnitOfStudy);
        System.out.println("recommendedSemesters: " + recommendedSemesters);
        System.out.println("credit: " + credit);
        System.out.println("preconditions: " + preconditions);
        System.out.println("containsWeakPreconditions: " + containsWeakPreconditions);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeOfUnitOfStudy() {
        return codeOfUnitOfStudy;
    }

    public void setCodeOfUnitOfStudy(String codeOfUnitOfStudy) {
        this.codeOfUnitOfStudy = codeOfUnitOfStudy;
    }

    public String getNameOfUnitOfStudy() {
        return nameOfUnitOfStudy;
    }

    public void setNameOfUnitOfStudy(String nameOfUnitOfStudy) {
        this.nameOfUnitOfStudy = nameOfUnitOfStudy;
    }

    public TypeOfUnitOfStudy getTypeOfUnitOfStudy() {
        return typeOfUnitOfStudy;
    }

    public void setTypeOfUnitOfStudy(TypeOfUnitOfStudy typeOfUnitOfStudy) {
        this.typeOfUnitOfStudy = typeOfUnitOfStudy;
    }

    public List<Integer> getRecommendedSemesters() {
        return recommendedSemesters;
    }

    public void setRecommendedSemesters(List<Integer> recommendedSemesters) {
        this.recommendedSemesters = recommendedSemesters;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<String> getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(List<String> preconditions) {
        this.preconditions = preconditions;
    }

    public boolean isContainsWeakPreconditions() {
        return containsWeakPreconditions;
    }

    public void setContainsWeakPreconditions(boolean containsWeakPreconditions) {
        this.containsWeakPreconditions = containsWeakPreconditions;
    }
}
