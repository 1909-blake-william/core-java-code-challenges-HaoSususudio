package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluationService {

    /**
     * 1. Without using the StringBuilder or StringBuffer class, write a method that
     * reverses a String. Example: reverse("example"); -> "elpmaxe"
     * 
     * @param string
     * @return
     */
    public String reverse(String string) {
        char[] reversed = new char[string.length()];
        for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = string.charAt(i);
        }
        return new String(reversed);
    }

    /**
     * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
     * Acronyms)! Help generate some jargon by writing a program that converts a
     * long name like Portable Network Graphics to its acronym (PNG).
     * 
     * @param phrase
     * @return
     */
    public String acronym(String phrase) {
        String[] splittedPhrase = phrase.split("[ -]+");
        StringBuilder accronymOut = new StringBuilder(splittedPhrase.length);
        for (String word : splittedPhrase) {
            accronymOut.append(word.charAt(0));
        }
        return accronymOut.toString().toUpperCase();
    }

    /**
     * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
     * equilateral triangle has all three sides the same length. An isosceles
     * triangle has at least two sides the same length. (It is sometimes specified
     * as having exactly two sides the same length, but for the purposes of this
     * exercise we'll say at least two.) A scalene triangle has all sides of
     * different lengths.
     *
     */
    static class Triangle {
        private double sideOne;
        private double sideTwo;
        private double sideThree;

        public Triangle() {
            super();
        }

        public Triangle(double sideOne, double sideTwo, double sideThree) {
            this();
            this.sideOne = sideOne;
            this.sideTwo = sideTwo;
            this.sideThree = sideThree;
        }

        public double getSideOne() {
            return sideOne;
        }

        public void setSideOne(double sideOne) {
            this.sideOne = sideOne;
        }

        public double getSideTwo() {
            return sideTwo;
        }

        public void setSideTwo(double sideTwo) {
            this.sideTwo = sideTwo;
        }

        public double getSideThree() {
            return sideThree;
        }

        public void setSideThree(double sideThree) {
            this.sideThree = sideThree;
        }

        public double[] accendingSortedSides() {
            double[] sortedSides = { this.sideOne, this.sideTwo, this.sideThree };
            Arrays.sort(sortedSides);
            return sortedSides;
        }

        public boolean isTriangle() {
            double[] sortedSides = accendingSortedSides();
            if (!(sortedSides[0] > 0 && sortedSides[1] > 0 && sortedSides[2] > 0)) {
                System.out.println("All sides of the triagle should be positive");
                return false;
            } else if (sortedSides[0] + sortedSides[1] <= sortedSides[2]) {
                System.out.println(
                        "Sum of the two short sides of the triangle " + "should be larger than the longest side.");
                return false;
            } else {
                return true;
            }
        }

        public boolean isEquilateral() {
            if (isTriangle()) {
                if ((this.sideOne == this.sideTwo) && (this.sideTwo == this.sideThree)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isIsosceles() {
            if (isTriangle()) {
                if (this.sideOne == this.sideTwo || this.sideOne == this.sideThree || this.sideTwo == this.sideThree) {
                    return true;
                }
            }
            return false;
        }

        public boolean isScalene() {
            if (isTriangle()) {
                if (!isEquilateral()) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 4. Given a word, compute the scrabble score for that word.
     * 
     * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
     * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
     * "cabbage" should be scored as worth 14 points:
     * 
     * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
     * point for E And to total:
     * 
     * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
     * 
     * @param string
     * @return
     */

    public int getScrabbleScore(String string) {
        HashMap<Character, Integer> scrabbleScoreMap = new HashMap<Character, Integer>();
        scrabbleScoreMap.put('A', 1);
        scrabbleScoreMap.put('E', 1);
        scrabbleScoreMap.put('I', 1);
        scrabbleScoreMap.put('O', 1);
        scrabbleScoreMap.put('U', 1);
        scrabbleScoreMap.put('L', 1);
        scrabbleScoreMap.put('N', 1);
        scrabbleScoreMap.put('R', 1);
        scrabbleScoreMap.put('S', 1);
        scrabbleScoreMap.put('T', 1);
        scrabbleScoreMap.put('D', 2);
        scrabbleScoreMap.put('G', 2);
        scrabbleScoreMap.put('B', 3);
        scrabbleScoreMap.put('C', 3);
        scrabbleScoreMap.put('M', 3);
        scrabbleScoreMap.put('P', 3);
        scrabbleScoreMap.put('F', 4);
        scrabbleScoreMap.put('H', 4);
        scrabbleScoreMap.put('V', 4);
        scrabbleScoreMap.put('W', 4);
        scrabbleScoreMap.put('Y', 4);
        scrabbleScoreMap.put('K', 5);
        scrabbleScoreMap.put('J', 8);
        scrabbleScoreMap.put('X', 8);
        scrabbleScoreMap.put('Q', 10);
        scrabbleScoreMap.put('Z', 10);

        int score = 0;
        char[] charsOfBrokendownString = string.toUpperCase().toCharArray();
        for (char c : charsOfBrokendownString) {
            score += scrabbleScoreMap.get(c);
        }
        return score;
    }

    /**
     * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
     * 
     * The North American Numbering Plan (NANP) is a telephone numbering system used
     * by many countries in North America like the United States, Canada or Bermuda.
     * All NANP-countries share the same international country code: 1.
     * 
     * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
     * Area code, commonly known as area code, followed by a seven-digit local
     * number. The first three digits of the local number represent the exchange
     * code, followed by the unique four-digit number which is the subscriber
     * number.
     * 
     * The format is usually represented as
     * 
     * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
     * from 0 through 9.
     * 
     * Your task is to clean up differently formatted telephone numbers by removing
     * punctuation and the country code (1) if present.
     * 
     * For example, the inputs
     * 
     * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
     * the output
     * 
     * 6139950253
     * 
     * Note: As this exercise only deals with telephone numbers used in
     * NANP-countries, only 1 is considered a valid country code.
     */
    public String cleanPhoneNumber(String string) throws IllegalArgumentException {
        char[] charsOfBrokendownString = string.toUpperCase().toCharArray();
        StringBuilder numberCollector = new StringBuilder();

        for (Character c : charsOfBrokendownString) {
            if (c.toString().matches("[0-9]")) {
                numberCollector.append(c);
            }
        }

        String tenDigitPhoneNumber = numberCollector.toString();

        // Check if first number of tenDigitPhoneNumber is 1.
        // Then drop the first number oftenDigitPhoneNumber.
        // Then check if tenDigitPhoneNumber has 10.
        if (tenDigitPhoneNumber.length() == 11 && tenDigitPhoneNumber.charAt(0) != '1') {
            throw new IllegalArgumentException();
        } else if (tenDigitPhoneNumber.length() == 11) {
            tenDigitPhoneNumber = tenDigitPhoneNumber.substring(1);
        } else if (tenDigitPhoneNumber.length() != 10) {
            throw new IllegalArgumentException();
        }
        // Check the first and fourth digit
        if (tenDigitPhoneNumber.charAt(0) == '1' || tenDigitPhoneNumber.charAt(3) == '1') {
            throw new IllegalArgumentException();
        } else {
            return tenDigitPhoneNumber;
        }
    }

    /**
     * 6. Given a phrase, count the occurrences of each word in that phrase.
     * 
     * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
     * free: 1
     * 
     * @param string
     * @return
     */
    public Map<String, Integer> wordCount(String string) {
        String[] splittedString = string.split("[ ,\n]");
        Map<String, Integer> wordCatcherCounter = new HashMap<String, Integer>();
        for (String word : splittedString) {
            if (!"".equals(word)) {
                if (!wordCatcherCounter.containsKey(word)) {
                    wordCatcherCounter.put(word, 1);
                } else {
                    wordCatcherCounter.replace(word, wordCatcherCounter.get(word) + 1);
                }
            }
        }
        return wordCatcherCounter;
    }

    /**
     * 7. Implement a binary search algorithm.
     * 
     * Searching a sorted collection is a common task. A dictionary is a sorted list
     * of word definitions. Given a word, one can find its definition. A telephone
     * book is a sorted list of people's names, addresses, and telephone numbers.
     * Knowing someone's name allows one to quickly find their telephone number and
     * address.
     * 
     * If the list to be searched contains more than a few items (a dozen, say) a
     * binary search will require far fewer comparisons than a linear search, but it
     * imposes the requirement that the list be sorted.
     * 
     * In computer science, a binary search or half-interval search algorithm finds
     * the position of a specified input value (the search "key") within an array
     * sorted by key value.
     * 
     * In each step, the algorithm compares the search key value with the key value
     * of the middle element of the array.
     * 
     * If the keys match, then a matching element has been found and its index, or
     * position, is returned.
     * 
     * Otherwise, if the search key is less than the middle element's key, then the
     * algorithm repeats its action on the sub-array to the left of the middle
     * element or, if the search key is greater, on the sub-array to the right.
     * 
     * If the remaining array to be searched is empty, then the key cannot be found
     * in the array and a special "not found" indication is returned.
     * 
     * A binary search halves the number of items to check with each iteration, so
     * locating an item (or determining its absence) takes logarithmic time. A
     * binary search is a dichotomic divide and conquer search algorithm.
     * 
     */
    static class BinarySearch<T extends Comparable<T>> {
        private List<T> sortedList;

        public int indexOf(T t) {
            if (!this.sortedList.contains(t)) {
                System.out.println("Element is not found in the sortedList");
                return -1;
            }

            int stepsOfIndexMovement = this.sortedList.size() / 2;
            int midIndex = stepsOfIndexMovement;
            int singleStepMoveCount = 0;
//            System.out.println("before while loop: index:" + midIndex + ", steps: " + stepsOfIndexMovement);
            while (t.compareTo(this.sortedList.get(midIndex)) != 0 && singleStepMoveCount < 3) {
                stepsOfIndexMovement = (int) Math.ceil((double) (stepsOfIndexMovement / 2.0));
//                System.out.println("before move: index:" + midIndex + ", steps: " + stepsOfIndexMovement);
                if (t.compareTo(this.sortedList.get(midIndex)) > 0) {
                    midIndex += stepsOfIndexMovement;
                } else if (t.compareTo(this.sortedList.get(midIndex)) < 0) {
                    midIndex -= stepsOfIndexMovement;
                }
//                System.out.println("after move: index:" + midIndex + ", steps: " + stepsOfIndexMovement);
                if (stepsOfIndexMovement == 1) {
                    singleStepMoveCount++;
                }
            }
//            System.out.println("single step:" + singleStepMoveCount);
            if (singleStepMoveCount == 3) {
                System.out.println("Element is not found in the sortedList");
                return -1;
            } else {
                return midIndex;
            }
        }

        public BinarySearch(List<T> sortedList) {
            super();
            this.sortedList = sortedList;
        }

        public List<T> getSortedList() {
            return sortedList;
        }

        public void setSortedList(List<T> sortedList) {
            this.sortedList = sortedList;
        }

    }

    /**
     * 8. Implement a program that translates from English to Pig Latin.
     * 
     * Pig Latin is a made-up children's language that's intended to be confusing.
     * It obeys a few simple rules (below), but when it's spoken quickly it's really
     * difficult for non-children (and non-native speakers) to understand.
     * 
     * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
     * the word. Rule 2: If a word begins with a consonant sound, move it to the end
     * of the word, and then add an "ay" sound to the end of the word. There are a
     * few more rules for edge cases, and there are regional variants too.
     * 
     * See http://en.wikipedia.org/wiki/Pig_latin for more details.
     * 
     * @param string
     * @return
     */
    public String toPigLatin(String string) {
        String[] splittedString = string.split(" ");
        StringBuilder outString = new StringBuilder();
        for (String word : splittedString) {
            outString.append(singleWordToPigLatin(word) + " ");
        }
        outString.deleteCharAt(outString.length() - 1); // delete the last space
        return outString.toString();
    }

    /**
     * This method takes in a single English word and return the Pig Latin Version
     * of it in lower cases.
     * 
     * @param singleWord Input argument. A single English word containing only
     *                   [a-zA-Z]
     * @return Pig Latin version of input word all in lower cases.
     */
    public String singleWordToPigLatin(String singleWord) {
        singleWord = singleWord.toLowerCase();
        int firstVowelIndex = indexOfFirstVowel(singleWord);
        if (firstVowelIndex == -1 || firstVowelIndex == 0) {
            return singleWord + "ay";
        } else if (singleWord.charAt(firstVowelIndex) == 'u' && singleWord.charAt(firstVowelIndex - 1) == 'q') {
            String leadingConsonantBlock = singleWord.substring(0, firstVowelIndex + 1);
            String tailingVowelBlock = singleWord.substring(firstVowelIndex + 1);
            return tailingVowelBlock + leadingConsonantBlock + "ay";
        } else {
            String leadingConsonantBlock = singleWord.substring(0, firstVowelIndex);
            String tailingVowelBlock = singleWord.substring(firstVowelIndex);
            return tailingVowelBlock + leadingConsonantBlock + "ay";
        }

    }

    /**
     * This method returns the index of the first vowel in the input word.
     * 
     * @param singleWord
     * @return returns -1 is there is no vowel in the word.
     */
    public int indexOfFirstVowel(String singleWord) {
        char[] charsOfSingleWord = singleWord.toLowerCase().toCharArray();
        int firstVowelIndex = 0;
        for (char c : charsOfSingleWord) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return firstVowelIndex;
            }
            firstVowelIndex += 1;
        }
        return -1;
    }

    /**
     * 9. An Armstrong number is a number that is the sum of its own digits each
     * raised to the power of the number of digits.
     * 
     * For example:
     * 
     * 9 is an Armstrong number, because 9 = 9^1 = 9. 10 is not an Armstrong number,
     * because 10 != 1^2 + 0^2 = 2. 153 is an Armstrong number, because: 153 = 1^3 +
     * 5^3 + 3^3 = 1 + 125 + 27 = 153. 154 is not an Armstrong number, because: 154
     * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190. Write some code to determine whether
     * a number is an Armstrong number.
     * 
     * @param input
     * @return
     */
    public boolean isArmstrongNumber(int input) {
        char[] inputNumberChars = Integer.toString(input).toCharArray();
        int decimalExponent = inputNumberChars.length;
        int sum = 0;
        for (char c : inputNumberChars) {
            sum += Math.pow(Character.getNumericValue(c), decimalExponent);
        }

        return sum == input ? true : false;
    }

    /**
     * 10. Compute the prime factors of a given natural number.
     * 
     * A prime number is only evenly divisible by itself and 1.
     * 
     * Note that 1 is not a prime number.
     * 
     * @param
     * @return
     */
    public List<Long> calculatePrimeFactorsOf(long l) {
        List<Long> primeFactors = new ArrayList<Long>();
        // Print the number of 2s that divide n
        while (l % 2 == 0) {
            primeFactors.add(2l);
            l /= 2;
        }

        for (long i = 3; i <= Math.sqrt(l); i += 2) {
            // While i divides l, print i and divide l
            while (l % i == 0) {
                primeFactors.add(i);
                l /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (l > 2) {
            primeFactors.add(l);
        }
        return primeFactors;
    }

    /**
     * 11. Create an implementation of the rotational cipher, also sometimes called
     * the Caesar cipher.
     * 
     * The Caesar cipher is a simple shift cipher that relies on transposing all the
     * letters in the alphabet using an integer key between 0 and 26. Using a key of
     * 0 or 26 will always yield the same output due to modular arithmetic. The
     * letter is shifted for as many values as the value of the key.
     * 
     * The general notation for rotational ciphers is ROT + <key>. The most commonly
     * used rotational cipher is ROT13.
     * 
     * A ROT13 on the Latin alphabet would be as follows:
     * 
     * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
     * stronger than the Atbash cipher because it has 27 possible keys, and 25
     * usable keys.
     * 
     * Ciphertext is written out in the same formatting as the input including
     * spaces and punctuation.
     * 
     * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
     * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
     * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
     * quick brown fox jumps over the lazy dog.
     */
    static class RotationalCipher {
        private int key;

        public RotationalCipher(int key) {
            super();
            this.key = key;
        }

        public String rotate(String string) {
            char[] charsOfBrokendownString = string.toCharArray();
            StringBuilder outputCharCatcher = new StringBuilder();
            char rotatedC = ' ';
            int rotatedCValue = 0;
            for (char c : charsOfBrokendownString) {
                if (Character.isUpperCase(c)) {
                    rotatedCValue = c + this.key;
                    if (rotatedCValue > 90) {
                        rotatedCValue -= 26;
                    }
                    rotatedC = (char) (rotatedCValue);
                    outputCharCatcher.append(rotatedC);
                } else if (Character.isLowerCase(c)) {
                    rotatedCValue = c + this.key;
                    if (rotatedCValue > 122) {
                        rotatedCValue -= 26;
                    }
                    rotatedC = (char) (rotatedCValue);
                    outputCharCatcher.append(rotatedC);
                } else {
                    outputCharCatcher.append(c);
                }
            }
            return outputCharCatcher.toString();
        }
    }

    /**
     * 12. Given a number n, determine what the nth prime is.
     * 
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
     * that the 6th prime is 13.
     * 
     * If your language provides methods in the standard library to deal with prime
     * numbers, pretend they don't exist and implement them yourself.
     * 
     * @param i
     * @return
     */
    public int calculateNthPrime(int nTh) throws IllegalArgumentException {
        List<Integer> primeNumbers = new ArrayList<Integer>();
        primeNumbers.add(2);
        int naturalNumberRunner = 2;

        if (nTh < 1) {
            throw new IllegalArgumentException();
        }
        while (nTh > primeNumbers.size()) {
            int indexPrimeNumbers = 0;
            while (indexPrimeNumbers < primeNumbers.size()
                    && naturalNumberRunner % primeNumbers.get(indexPrimeNumbers) != 0) {
                indexPrimeNumbers += 1;
            }

            if (indexPrimeNumbers == primeNumbers.size()) {
                primeNumbers.add(naturalNumberRunner);
            }
            naturalNumberRunner += 1;
        }
//        System.out.println(primeNumbers);
        return primeNumbers.get(primeNumbers.size() - 1);
    }

    /**
     * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
     * system created in the Middle East.
     * 
     * The Atbash cipher is a simple substitution cipher that relies on transposing
     * all the letters in the alphabet such that the resulting alphabet is
     * backwards. The first letter is replaced with the last letter, the second with
     * the second-last, and so on.
     * 
     * An Atbash cipher for the Latin alphabet would be as follows:
     * 
     * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
     * very weak cipher because it only has one possible key, and it is a simple
     * monoalphabetic substitution cipher. However, this may not have been an issue
     * in the cipher's time.
     * 
     * Ciphertext is written out in groups of fixed length, the traditional group
     * size being 5 letters, and punctuation is excluded. This is to make it harder
     * to guess things based on word boundaries.
     * 
     * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
     * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
     *
     */
    static class AtbashCipher {

        /**
         * Question 13
         * 
         * @param string
         * @return
         */
        public static String encode(String string) {
            char[] charsOfBrokendownString = string.toCharArray();
            StringBuilder outputCharCatcher = new StringBuilder();
            char encodedC = ' ';
            int encodedCValue = 0;
            for (char c : charsOfBrokendownString) {
                if (Character.isUpperCase(c)) {
                    encodedCValue = (int) ((c - 78) * (-1) + 109);
                    encodedC = (char) (encodedCValue);
                    outputCharCatcher.append(encodedC);
                } else if (Character.isLowerCase(c)) {
                    encodedCValue = (int) ((c - 110) * (-1) + 109);
                    encodedC = (char) (encodedCValue);
                    outputCharCatcher.append(encodedC);
                } else if (Character.isDigit(c)) {
                    outputCharCatcher.append(c);
                }
            }

            int numOfInsertedSpace = 0;
            int totalNumOfSpace = outputCharCatcher.length() / 5;
            if (outputCharCatcher.length() % 5 == 0) {
                totalNumOfSpace -= 1;
            }
            while (numOfInsertedSpace < totalNumOfSpace) {
                outputCharCatcher.insert((numOfInsertedSpace + 1) * 5 + numOfInsertedSpace, ' ');
                numOfInsertedSpace += 1;
            }
            return outputCharCatcher.toString();
        }

        /**
         * Question 14
         * 
         * @param string
         * @return
         */
        public static String decode(String string) {
            char[] charsOfBrokendownString = string.toCharArray();
            StringBuilder outputCharCatcher = new StringBuilder();
            char encodedC = ' ';
            int encodedCValue = 0;
            for (char c : charsOfBrokendownString) {
                if (Character.isUpperCase(c)) {
                    encodedCValue = (int) ((c - 78) * (-1) + 109);
                    encodedC = (char) (encodedCValue);
                    outputCharCatcher.append(encodedC);
                } else if (Character.isLowerCase(c)) {
                    encodedCValue = (int) ((c - 110) * (-1) + 109);
                    encodedC = (char) (encodedCValue);
                    outputCharCatcher.append(encodedC);
                } else if (Character.isDigit(c)) {
                    outputCharCatcher.append(c);
                }
            }
            return outputCharCatcher.toString();
        }

    }

    /**
     * 15. The ISBN-10 verification process is used to validate book identification
     * numbers. These normally contain dashes and look like: 3-598-21508-8
     * 
     * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
     * a digit or an X only). In the case the check character is an X, this
     * represents the value '10'. These may be communicated with or without hyphens,
     * and can be checked for their validity by the following formula:
     * 
     * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
     * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
     * otherwise it is invalid.
     * 
     * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
     * and get:
     * 
     * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
     * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
     * 
     * @param string
     * @return
     */
    public boolean isValidIsbn(String string) {
        // If the string contains anything but 0-9, '-' or X, return false right away.
        if (!string.matches("^[\\d\\-]*[\\dX]$")) {
            System.out.println("ISBN can only contain 0-9, '-' and X in the last digit.");
            return false;
        }

        // Clean up '-' in the string. keep 0-9 and X's only.
        char[] charsOfBrokendownString = string.toUpperCase().toCharArray();
        StringBuilder digitsAndXsCollector = new StringBuilder();
        for (Character c : charsOfBrokendownString) {
            if (c.toString().matches("[\\dX]")) {
                digitsAndXsCollector.append(c);
            }
        }
        String isbnNumbersAndXOnly = digitsAndXsCollector.toString();

        // Check if 10 digits and X position
        if (isbnNumbersAndXOnly.length() != 10) {
            System.out.println("ISBN can only be 10-digit");
            return false;
        }

        // Calculate ISBN check sum.
        int sumISBN = 0;
        for (int index = 0; index < 9; index++) {
            sumISBN += Character.getNumericValue(isbnNumbersAndXOnly.charAt(index)) * (10 - index);
        }
        if (isbnNumbersAndXOnly.charAt(9) == 'X') {
            sumISBN += 10;
        } else {
            sumISBN += Character.getNumericValue(isbnNumbersAndXOnly.charAt(9));
        }

        // Check sum results.
        return sumISBN % 11 == 0 ? true : false;
    }

    /**
     * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
     * gramma, "every letter") is a sentence using every letter of the alphabet at
     * least once. The best known English pangram is:
     * 
     * The quick brown fox jumps over the lazy dog.
     * 
     * The alphabet used consists of ASCII letters a to z, inclusive, and is case
     * insensitive. Input will not contain non-ASCII symbols.
     * 
     * @param string
     * @return
     */
    public boolean isPangram(String string) {
        char[] charsOfString = string.toLowerCase().toCharArray();
        Map<Character, Boolean> ifLettersUsed = new HashMap<Character, Boolean>();
        for (int asciiIndex = 97; asciiIndex < 123; asciiIndex += 1) {
            ifLettersUsed.put((char) (asciiIndex), false);
        }

        for (char c : charsOfString) {
            if (ifLettersUsed.containsKey(c) && ifLettersUsed.get(c) == false) {
                ifLettersUsed.replace(c, true);
            }
        }

        return ifLettersUsed.containsValue(false) ? false : true;
    }

    /**
     * 17. Calculate the moment when someone has lived for 10^9 seconds.
     * 
     * A gigasecond is 109 (1,000,000,000) seconds.
     * 
     * @param given
     * @return
     */
    public Temporal getGigasecondDate(Temporal given) {
        LocalDateTime givenWithAddedTimeStamp = LocalDateTime.now();
        if (given instanceof LocalDate) {
            givenWithAddedTimeStamp = LocalDateTime.of((LocalDate) given, LocalTime.of(0, 0, 0));
        } else if (given instanceof LocalDateTime) {
            givenWithAddedTimeStamp = (LocalDateTime) given;
        }
        return givenWithAddedTimeStamp.plusSeconds((long) Math.pow(10, 9));
    }

    /**
     * 18. Given a number, find the sum of all the unique multiples of particular
     * numbers up to but not including that number.
     * 
     * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
     * get 3, 5, 6, 9, 10, 12, 15, and 18.
     * 
     * The sum of these multiples is 78.
     * 
     * @param i
     * @param set
     * @return
     */
    public int getSumOfMultiples(int numberCeiling, int[] numbers) {
        HashSet<Integer> numCollector = new HashSet<Integer>();

        for (int num : numbers) {
            int multiplier = 1;
            while (num * multiplier < numberCeiling) {
                numCollector.add(num * multiplier);
                multiplier += 1;
            }
        }
//        System.out.println(numCollector.toString());
        return numCollector.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 19. Given a number determine whether or not it is valid per the Luhn formula.
     * 
     * The Luhn algorithm is a simple checksum formula used to validate a variety of
     * identification numbers, such as credit card numbers and Canadian Social
     * Insurance Numbers.
     * 
     * The task is to check if a given string is valid.
     * 
     * Validating a Number Strings of length 1 or less are not valid. Spaces are
     * allowed in the input, but they should be stripped before checking. All other
     * non-digit characters are disallowed.
     * 
     * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
     * the Luhn algorithm is to double every second digit, starting from the right.
     * We will be doubling
     * 
     * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
     * then subtract 9 from the product. The results of our doubling:
     * 
     * 8569 2478 0383 3437 Then sum all of the digits:
     * 
     * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
     * then the number is valid. This number is valid!
     * 
     * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
     * digits, starting from the right
     * 
     * 7253 2262 5312 0539 Sum the digits
     * 
     * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
     * this number is not valid.
     * 
     * @param string
     * @return
     */
    public boolean isLuhnValid(String string) {
        if (!string.matches("[\\d\\ ]*")) {
            System.out.println("Luhn numbers can only contain 0-9 and spaces");
            return false;
        }

        // Clean up spaces in the string. Keep 0-9 only.
        char[] charsOfString = string.toCharArray();
        StringBuilder digitsCollector = new StringBuilder();
        for (Character c : charsOfString) {
            if (c.toString().matches("[\\d]")) {
                digitsCollector.append(c);
            }
        }

        // check length
        if (digitsCollector.length() < 2) {
            System.out.println("Luhn numbers must contain 2 or more digits");
            return false;
        }

        int luhnSum = 0;
        // Odd digits from the right
        for (int index = digitsCollector.length() - 1; index >= 0; index -= 2) {
            luhnSum += Character.getNumericValue(digitsCollector.charAt(index));
        }

        // Even digits from the right
        for (int index = digitsCollector.length() - 2; index >= 0; index -= 2) {
            luhnSum += luhnDigitDoubler(Character.getNumericValue(digitsCollector.charAt(index)));
        }

        return luhnSum % 10 == 0 ? true : false;
    }

    public int luhnDigitDoubler(int digit) throws IllegalArgumentException {
        if (0 <= digit && digit <= 4) {
            return digit * 2;
        } else if (5 <= digit && digit <= 9) {
            return digit * 2 - 9;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 20. Parse and evaluate simple math word problems returning the answer as an
     * integer.
     * 
     * Add two numbers together.
     * 
     * What is 5 plus 13?
     * 
     * 18
     * 
     * Now, perform the other three operations.
     * 
     * What is 7 minus 5?
     * 
     * 2
     * 
     * What is 6 multiplied by 4?
     * 
     * 24
     * 
     * What is 25 divided by 5?
     * 
     * 5
     * 
     * @param string
     * @return
     */
    public int solveWordProblem(String algebraInquary) throws IllegalArgumentException {
        String[] words = algebraInquary.split("[ ,?!]+");

        int[] locIndexOfNumbers = new int[2];
        int[] numbers = new int[2];

        int numberIndex = 0;
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            if (words[wordIndex].matches("^[\\d\\-\\+][\\d]*")) {
                locIndexOfNumbers[numberIndex] = wordIndex;
                numbers[numberIndex] = Integer.valueOf(words[wordIndex]);
                numberIndex++;
            }
        }

        String operatorDescription = "";
        int locIndex = locIndexOfNumbers[0];
        do {
            operatorDescription += words[locIndex + 1] + ' ';
            locIndex += 1;
        } while (locIndex < locIndexOfNumbers[1] - 1);

        switch (operatorDescription) {
        case "plus ":
            return numbers[0] + numbers[1];
        case "minus ":
            return numbers[0] - numbers[1];
        case "multiplied by ":
            return numbers[0] * numbers[1];
        case "divided by ":
            return numbers[0] / numbers[1];
        default:
            System.out.println("Sorry I don't understand.");
            throw new IllegalArgumentException();
        }

    }

}