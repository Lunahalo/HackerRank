package anagrams;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {
    public static int numberNeeded(String first, String second) {
        LinkedList[] firstWordLetters = createLetterArray(first);
        LinkedList[] secondWordLetters = createLetterArray(second);
        List<Character> deletedLetter = new ArrayList();
        for(int i = 0; i < 26; i++) {
            if(!firstWordLetters[i].isEmpty() && secondWordLetters[i].isEmpty()) {
                /*If the letter is in the first word but not in the second,
                 remove all instance of that letter from the first word and add 
                 it to the deleted letters list
                 */
                while(firstWordLetters[i].size() > 0) {
                    deletedLetter.add((Character) firstWordLetters[i].removeFirst());
                }
            }
            else if(!secondWordLetters[i].isEmpty() && firstWordLetters[i].isEmpty()) {
                while(secondWordLetters[i].size() > 0) {
                    /* same as above for the second word
                     */
                    deletedLetter.add((Character) secondWordLetters[i].removeFirst());
                }
            }
            else /*if(!firstWordLetters[i].isEmpty() && !secondWordLetters[i].isEmpty())/ {
                /*If the letter is in both words check to see how many times that letter shows up
                and remove the extra copies*/
                while(firstWordLetters[i].size() > secondWordLetters[i].size()) {
                    deletedLetter.add((Character) firstWordLetters[i].removeFirst());
                }
                while(secondWordLetters[i].size() > firstWordLetters[i].size()) {
                    deletedLetter.add((Character) secondWordLetters[i].removeFirst());
                }
            /*}*/
        }

        return deletedLetter.size();
    }

    public static LinkedList[] createLetterArray(String word) {
        //construct an array of LinkedLists to hold as many instances of letters as needed
        LinkedList[] letterArray = new LinkedList[26];
        for(int i = 0; i < 26; i++) {
            letterArray[i] = new LinkedList<>();
        }

        Character letter;
        int letterIndex;
        for(int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);
            //the first letter (a) has a value of 10, according to the method
            letterIndex = Character.getNumericValue(letter) - 10;
            //go to the index of the letter and add it
            letterArray[letterIndex].add(letter);
        }
        return letterArray;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("test.txt"));
        System.setIn(is);
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
