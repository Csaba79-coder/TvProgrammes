package testExam.processor;

import testExam.controller.MajorController;
import testExam.enumerations.TypeOfUnitOfStudy;
import testExam.major.Major;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Processor {

    public static void makeTasks(){

        MajorController controller = new MajorController();

        System.out.println("1. Olvasd be a fájlt szak szerint rendezve!");
        System.out.println();

        Map<String, List<Major>> majorsAndUnitOfStudy = controller.getMajorsAndUnitOfStudyMap();
        controller.showSortedMap1(majorsAndUnitOfStudy);


        System.out.println("2. Írj metódust, amely visszaadja (adatszerkezetben) azoknak a tanegységeket, amelyeknek " +
                "nincs semmilyen előfeltétele.");
        System.out.println();

        List<Major> majorsWithoutPrecondition = controller.getMajorsWithoutPrecondition();


        System.out.println("3. Írj metódust, amely két bemeneti paramétert kap: a szakhoz tartozó tanegységek " +
                "listáját és egy típust, és visszaadja (adatszerkezetben) az összes olyan típusú tanegységet a " +
                "bemeneti paraméterként kapott listából.");
        System.out.println();

        List<Major> majorsColloquiumOfFirstUnitOfStudy =
                controller.getMajorsWithSameTypeOfUnitOfStudyFromSameUnitOfStudyList(majorsAndUnitOfStudy.get("germanisztika"),
                TypeOfUnitOfStudy.K);

        System.out.println("4. Írj metódust, amely visszaadja az első legtöbb előfeltétellel rendelkező tanegységet " +
                "(az összes tanegység közül, és nem szakonként)!");
        System.out.println();

        Major firstMostPrecondition = controller.getFirstMostPrecondition();
        firstMostPrecondition.showMyMajor();


        /*System.out.println("5. Írj metódust, amely visszaadja azt a tanegységet (vagy tanegységeket), ahol a legtöbb " +
                "egymásra épülő előfeltétel van!");
        System.out.println();

        Set<Major> theLongestPreconditionMajorChain = controller.getTheLongestPreconditionMajorChain();

        for (Major major : theLongestPreconditionMajorChain) {
            major.showMyMajor();
        }*/

        System.out.println("5. Írj metódust, amely visszaadja azt a tanegységet (vagy tanegységeket), ahol a legtöbb " +
                "egymásra épülő előfeltétel van!");
        System.out.println();

        List<List<Major>> myList = controller.recursionMethod();

        for (int i = 0; i < myList.size() ; i++) {
            for (Major major : myList.get(i)) {
                major.showMyMajor();
            }
            System.out.println("............................................");
        }

        System.out.println("Number of longest chains: " + myList.size());
        System.out.println("Length of longest chains: " + myList.get(0).size());
    }
}
