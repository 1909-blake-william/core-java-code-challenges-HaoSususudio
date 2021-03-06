package com.revature.eval.java.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.eval.java.core.EvaluationService.AtbashCipher;
import com.revature.eval.java.core.EvaluationService.RotationalCipher;

public class TestDriver {
    public static void main(String[] args) {
        EvaluationService es = new EvaluationService();
        RotationalCipher rc = new RotationalCipher(5);
        AtbashCipher ac = new AtbashCipher();
//        //Q1.
//        System.out.println(es.reverse("trew"));
        // Q2.
//        System.out.println(es.acronym("hhh kkk tom-jj jkkj"));
//        //Q3.
//        Triangle tri = new Triangle(6, 4, 5);
//        System.out.println(tri.isTriangle());
//        //Q4.
//        System.out.println(es.getScrabbleScore("cabbage"));
        // Q5.
//        System.out.println(es.cleanPhoneNumber("223.456.7890"));
        // Q6.
//        System.out.println(es.wordCount("one,\ntwo,\nthree"));
        // Q7.
        List<String> sortedList = Collections.unmodifiableList(Arrays.asList("1", "3", "4", "6", "8", "9", "11"));

        EvaluationService.BinarySearch<String> search = new EvaluationService.BinarySearch<>(sortedList);

//        assertEquals(3, search.indexOf("6"));
        System.out.println("\"1\" compTo \"3\": " + "1".compareTo("3"));
        System.out.println("\"3\" compTo \"4\": " + "3".compareTo("4"));
        System.out.println("\"4\" compTo \"6\": " + "4".compareTo("6"));
        System.out.println("\"6\" compTo \"8\": " + "6".compareTo("8"));
        System.out.println("\"8\" compTo \"9\": " + "8".compareTo("9"));
        System.out.println("\"9\" compTo \"11\": " + "9".compareTo("11"));
        System.out.println("\n");
        System.out.println("\"1\" compTo \"11\": " + "1".compareTo("11"));
        System.out.println("\"11\" compTo \"3\": " + "11".compareTo("3"));
//         Q8.
//        System.out.println(es.toPigLatin("I love you"));
        // Q9.
//        System.out.println(es.isArmstrongNumber(11));
        // Q10.
//        System.out.println(es.calculatePrimeFactorsOf(901255L));
        // Q11.
//        System.out.println(rc.rotate("OMG"));
        // Q12.
//        System.out.print(es.calculateNthPrime(10001));
        // Q13.
//        System.out.println(AtbashCipher.encode("vcvix rhn"));
        // Q14.
//        System.out.println(AtbashCipher.decode("vcvix rhn"));
        // Q15.
//        System.out.println(es.isValidIsbn("3-598-21500-X"));
        // Q16.
//        System.out.println(es.isPangram("test"));
        // Q17.
//        System.out.println(es.getGigasecondDate(LocalDate.of(1977, Month.JUNE, 13)));
        // Q18.
        // Q19.
//        System.out.println(es.isLuhnValid("4539 1488 0343 6467"));
        // Q20.
//        System.out.println(es.solveWordProblem("What is 1 plus 1?"));
    }
}