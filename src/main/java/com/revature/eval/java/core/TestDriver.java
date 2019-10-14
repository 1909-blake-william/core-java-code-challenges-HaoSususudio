package com.revature.eval.java.core;

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
//         Q8.
//        System.out.println(es.toPigLatin("I love you"));
        // Q9.
//        System.out.println(es.isArmstrongNumber(11));
        // Q10.
//        System.out.println(es.calculatePrimeFactorsOf(500l));
        // Q11.
//        System.out.println(rc.rotate("OMG"));
        // Q12.
//        es.calculateNthPrime(1)Q.
        // Q13.
//        System.out.println(AtbashCipher.encode("vcvix rhn"));
        // Q14.
//        System.out.println(AtbashCipher.decode("vcvix rhn"));
        // Q15.
//        System.out.println(es.isValidIsbn("3-598-21500-X"));
        // Q16.
//        System.out.println(es.isPangram("test"));
        // Q17.
        // Q18.
        // Q19.
//        System.out.println(es.isLuhnValid("4539 1488 0343 6467"));
        // Q20.
        System.out.println(es.solveWordProblem("What is -25 divided by +5?"));
    }
}