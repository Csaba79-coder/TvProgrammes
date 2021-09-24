package testExam.controller;

import testExam.enumerations.TypeOfUnitOfStudy;
import testExam.major.Major;
import testExam.utils.ObjectCreator;

import java.util.*;

public class MajorController {

    private List<Major> majors = new ArrayList<>();


    public MajorController() {
        loadMajorList();
    }

    private void loadMajorList(){
        ObjectCreator myCreator = new ObjectCreator();
        majors = myCreator.getMyMajors();
    }

    //4. Írj metódust, amely visszaadja az első legtöbb előfeltétellel rendelkező tanegységet (az összes tanegység közül, és nem szakonként)!
    public Major getFirstMostPrecondition(){

        Major firstMostPrecondition = new Major();

        int counter = 0;

        for (int i = 0; i < majors.size(); i++) {
            if(majors.get(i).getPreconditions().size() > counter){
                counter = majors.get(i).getPreconditions().size();
            }
        }

        for (int i = 0; i < majors.size(); i++) {
            if (majors.get(i).getPreconditions().size() == counter){
                firstMostPrecondition = majors.get(i);  // <<-- ezt az apróságot hagytam csak ki XD
                //majors.get(i).showMyMajor();
                break;
            }
        }
      return  firstMostPrecondition;
    }

    //2. Írj metódust, amely visszaadja (adatszerkezetben) azoknak a tanegységeket, amelyeknek nincs semmilyen előfeltétele.
    public List<Major> getMajorsWithoutPrecondition(){

        List<Major> majorsWithoutPrecondition = new ArrayList<>();

        for (int i = 0; i < majors.size(); i++) {
            if(majors.get(i).getPreconditions().get(0).equals("NULL")){
                majors.get(i).showMyMajor();
            }
        }
        return majorsWithoutPrecondition;
    }

    // 1. Olvasd be a fájlt szak szerint rendezve!
    public Map<String, List<Major>> getMajorsAndUnitOfStudyMap(){

        Map<String, List<Major>> majorsAndUnitOfStudy = new HashMap<>();

        for (int i = 0; i < majors.size(); i++) {

            if (majorsAndUnitOfStudy.containsKey(majors.get(i).getName())) {
                majorsAndUnitOfStudy.get(majors.get(i).getName()).add(majors.get(i));
            } else {
                List<Major> majorSortedList = new ArrayList<>();
                majorSortedList.add(majors.get(i));
                majorsAndUnitOfStudy.put(majors.get(i).getName(), majorSortedList);
            }
        }
        return majorsAndUnitOfStudy;
    }

    //Mutasd --> Olvasd be a fájlt szak szerint rendezve!
    public void showSortedMap1(Map<String, List<Major>> majorsAndUnitOfStudy){

        for(String key : majorsAndUnitOfStudy.keySet()){

            System.out.println(".....................................................");
            System.out.println(key);
            System.out.println(".....................................................");

            for (int i = 0; i < majorsAndUnitOfStudy.get(key).size(); i++) {
                majorsAndUnitOfStudy.get(key).get(i).showMyMajor();
            }
            System.out.println();
        }
    }

    //Mutasd --> Olvasd be a fájlt szak szerint rendezve!
    public void showSortedMap2 (Map<String, List<Major>> majorsAndUnitOfStudy){

        for(String key : majorsAndUnitOfStudy.keySet()){

            System.out.println(".....................................................");
            System.out.println(key);
            System.out.println(".....................................................");

            for (int i = 0; i < majorsAndUnitOfStudy.get(key).size(); i++) {
                System.out.println(majorsAndUnitOfStudy.get(key).get(i).getNameOfUnitOfStudy());
            }
            System.out.println();
        }
    }

    //3. Írj metódust, amely két bemeneti paramétert kap: a szakhoz tartozó tanegységek listáját és egy típust,
    // és visszaadja (adatszerkezetben) az összes olyan típusú tanegységet a bemeneti paraméterként kapott listából.
    public List<Major> getMajorsWithSameTypeOfUnitOfStudyFromSameUnitOfStudyList(List<Major> majors, TypeOfUnitOfStudy typeOfUnitOfStudy){

        List<Major> majorsWithSameTypeOfUnitOfStudy = new ArrayList<>();

        for (int i = 0; i < majors.size(); i++) {
            if(majors.get(i).getTypeOfUnitOfStudy().equals(typeOfUnitOfStudy)){
                majorsWithSameTypeOfUnitOfStudy.add(majors.get(i));
                majors.get(i).showMyMajor();
            }
        }
        return majorsWithSameTypeOfUnitOfStudy;
    }

    /*// 5. Írj metódust, amely visszaadja azt a tanegységet (vagy tanegységeket), ahol a legtöbb egymásra épülő előfeltétel van!
    public Set<Major> getTheLongestPreconditionMajorChain(){

        Set<Major> theLongestPreconditionMajorChain = new HashSet<>();
        List<Set<Major>> majorSets = new ArrayList<>();

        for (int i = 0; i < majors.size(); i++) {
            Set<Major> chainSet = new HashSet<>();
            chain(majors.get(i), chainSet);
            majorSets.add(chainSet);
        }

        for (int i = 0; i < majorSets.size(); i++) {
            if(majorSets.get(i).size() > theLongestPreconditionMajorChain.size())
                theLongestPreconditionMajorChain = majorSets.get(i);
        }

        return theLongestPreconditionMajorChain;
    }

    private void chain(Major major, Set<Major> theLongestPreconditionMajorChain){

        for (int i = 0; i < majors.size(); i++) {
            if(majors.get(i).getPreconditions().contains(major.getCodeOfUnitOfStudy())) {
                theLongestPreconditionMajorChain.add(major);
                theLongestPreconditionMajorChain.add(majors.get(i));
                major = majors.get(i);
            }
        }
    }*/

    // 5. Írj metódust, amely visszaadja azt a tanegységet (vagy tanegységeket), ahol a legtöbb egymásra épülő előfeltétel van!

    public List<List<Major>> recursionMethod(){

        List<List<Major>> allChainList = new ArrayList<>();

        for (int i = 0; i < majors.size(); i++) {
            List<List<Major>> currentChain = recursion(majors.get(i));
            if(allChainList.isEmpty()){
                allChainList = currentChain;
            }else if(allChainList.get(0).size() < currentChain.get(0).size()){
                allChainList = currentChain;
            }else if(allChainList.get(0).size() == currentChain.get(0).size()){
                allChainList.addAll(currentChain);
            }
        }
        return allChainList;
    }

    public List<List<Major>> recursion(Major major){

        if(!major.getPreconditions().get(0).equals("NULL")){
            List<List<Major>> chainList = new ArrayList<>();
            for (int i = 0; i < major.getPreconditions().size(); i++) {
                for (int j = 0; j < majors.size(); j++) {
                    if(major.getPreconditions().get(i).contains(majors.get(j).getCodeOfUnitOfStudy())){
                        List<List<Major>> currentChain = recursion(majors.get(j));
                        if(chainList.isEmpty()){
                            chainList = currentChain;
                        }else if(chainList.get(0).size() < currentChain.get(0).size()){
                            chainList = currentChain;
                        }else if(chainList.get(0).size() == currentChain.get(0).size()){
                            chainList.addAll(currentChain);
                        }
                    }
                }
            }
            for (int i = 0; i < chainList.size(); i++) {
                chainList.get(i).add(major);
            }
            return chainList;
        }
        else{
            List<List<Major>> longestChain = new ArrayList<>();
            List<Major> singleChain = new ArrayList<>();
            singleChain.add(major);
            longestChain.add(singleChain);
            return longestChain;
        }
    }

    public MajorController(List<Major> majors) {
        this.majors = majors;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }
}
