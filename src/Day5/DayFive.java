package Day5;

import Input.InputReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by BJ onB 2015-12-05.
 */
public class DayFive {
    private ArrayList<String> niceStrings;

    public static void main (String[] args) throws FileNotFoundException {
        DayFive dayFiveA = new DayFive("A");
        DayFive dayFiveB = new DayFive("B");
    }

    public DayFive(String option) {
        InputReader inputReader = new InputReader();
        ArrayList<String> input = inputReader.getLines("./src/Input/Day5_Input");
        niceStrings = new ArrayList<String>();
        if(option.equals("A")) partA(input);
        if(option.equals("B")) partB(input);
    }

    private void partA(ArrayList<String> input) {
        for(String line : input) {
            if(containsThreeVowels(line) && repeatedLetterAndNoExcludedSubString(line)){
                niceStrings.add(line);
            }
        }
         System.out.println("Part A = " + niceStrings.size());
    }

    private void partB(ArrayList<String> input) {
        for(String line : input) {
            if(appearsTwice(line) && repeatLetter(line)){
                niceStrings.add(line);
            }
        }
        System.out.println("Part B = " + niceStrings.size());
    }

    private boolean containsThreeVowels(String input) {
        int vowels = 0;
        for(char c : input.toCharArray()){
            if(c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u') vowels++;
        }
        return vowels >= 3;
    }

    private boolean repeatedLetterAndNoExcludedSubString(String input) {
        boolean repeatLetter = false;
        boolean noExcludedString = true;

        if(input.length() <= 1) return false;
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == input.charAt(i - 1)) repeatLetter = true;
            if(Arrays.asList("ab", "cd", "pq", "xy").contains(input.substring(i - 1, i + 1)))
                noExcludedString = false;
        }
        return (repeatLetter && noExcludedString);
    }

    private boolean appearsTwice(String input) {
        if(input.length() <= 3) return false;
        for(int i = 1; i < input.length(); i++){
            String sbstring = input.substring(i - 1, i + 1);
            for(int z = 1; z < input.length(); z++){
                String temp = input.substring(z - 1, z + 1);
                if(temp.equals(sbstring) && z != i && z != (i + 1) && z != (i - 1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean repeatLetter(String input) {
        if(input.length() <= 2) return false;
        for (int i = 1; i < input.length() - 1; i++) {
            if (input.charAt(i - 1) == input.charAt(i + 1)) return true;
        }
        return false;
    }
}
