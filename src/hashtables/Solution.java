package hashtables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public Solution(String magazine, String note, int m, int n) {
        String[] wordsInMag = magazine.split(" ");
        magazineMap = new HashMap<>(m);
        for(String word : wordsInMag) {
            Integer timesSeen = magazineMap.get(word);
            magazineMap.put(word, (timesSeen == null) ? 1 : timesSeen + 1);
        }

        String[] wordsInNote = note.split(" ");
        noteMap = new HashMap<>(n);
        for(String word : wordsInNote) {
            Integer timesSeen = noteMap.get(word);
            noteMap.put(word, (timesSeen == null) ? 1 : timesSeen + 1);
        }
    }

    public boolean solve() {
        //Get every key (word) in the note
        //Set <String> keySet = noteMap.keySet();
        //Iterator<String> keySetIter = keySet.iterator();
        //Map.Entry<String, Integer> entry = noteMap.entrySet();
        /*Create an iterator from the entrySet*/
        while(!noteMap.isEmpty()) {
            Iterator<Map.Entry<String, Integer>> iter = noteMap.entrySet().iterator();

            while(iter.hasNext()) {
                //Get the next entry and get the word (key)
                Map.Entry<String, Integer> entry = iter.next();
                String word = entry.getKey();
                //Check in the number of occurences remaining (value) for that word
                Integer copiesInMag = magazineMap.get(word);
                Integer copiesInNote = noteMap.get(word);
                /*If there are no more copies left in the magazine then we can't replicate the note*/
                if(copiesInMag == null || copiesInMag == 0) {
                    return false;
                }
                else {
                    /*There is at least 1 unused instance of the word 
                   left in the magazine, so mark 1 instance as used
                     */
                    magazineMap.put(word, copiesInMag - 1);
                }
                /*If we have reached here, we where able to replicate the word 
                from the note in the magazine, so if there was more than one 
                instance of that word, remove one of them.  Otherwise there was 
                only one instance of that word and we should remove it completly 
                from the map and iterator.*/
                if(copiesInNote > 1) {
                    noteMap.put(word, copiesInNote - 1);
                }
                /*There was only one copy of the word in the note, so we should remove it from the map and iterator.*/
                else {
                    //noteMap.remove(word);
                    iter.remove();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("test.txt"));
        System.setIn(is);
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        Solution s = new Solution(scanner.nextLine(), scanner.nextLine(), m, n);
        scanner.close();

        boolean answer = s.solve();
        if(answer) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
