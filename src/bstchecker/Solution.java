// @author Jared
package bstchecker;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        //Two cases
        //#1 n%k == 0 a cycle will form
        //#2 n%k != 0 a cycle will form only after all of the locations have been visited

        //#1
        if(n % k == 0) {
            for(int i = 1; i <= k; i++) {
                cycleNumbers(a, n, k, i);
            }
        }
        //#2
        else {
            int sourceIndex = n - 1;
            //TO-DO handle case where shift is larger than array size
            int destIndex;
            int secondreplacedNumber;
            int replacedNumber = a[sourceIndex];
            do {
                destIndex = wrapOffset(n, sourceIndex, k);
                secondreplacedNumber = a[destIndex];
                //left shift by precomputed amount
                a[destIndex] = replacedNumber;
                sourceIndex = destIndex;
                replacedNumber = secondreplacedNumber;
            }
            while(sourceIndex != n - 1);
        }

        return a;
    }
    /*returns the correct index after shifting source by distance equal to offset 
     for array of size arrayLength.
     Only works if offset is smaller than arrayLength*/

    static public int wrapOffset(int arrayLength, int source, int offset) {
        int value = source - offset;
        if(value < 0) {
            value = Math.abs(value);
            value = arrayLength - value;
        }
        return value;
    }

    static public void cycleNumbers(int[] a, int n, int k, int offset) {
        int sourceIndex = n - offset;
        int destIndex;
        int secondreplacedNumber;
        int replacedNumber = a[sourceIndex];
        do {
            destIndex = wrapOffset(n, sourceIndex, k);
            secondreplacedNumber = a[destIndex];
            //left shift by precomputed amount
            a[destIndex] = replacedNumber;
            sourceIndex = destIndex;
            replacedNumber = secondreplacedNumber;
        }
        while(sourceIndex != n - offset);
    }
    public static void testArray() {
        int[] previousNum = new int[5];
        for(int i = 0; i < 5; i++) {
            System.out.println(previousNum[i]);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("test.txt"));
        System.setIn(is);
        Scanner in = new Scanner(System.in);
        testArray();
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }

        System.out.println();

    }
}
