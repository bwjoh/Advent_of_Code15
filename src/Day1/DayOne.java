package Day1;

import Input.InputReader;

/**
 * Created by BJ on 2015-12-01.
 */
public class DayOne {
    private String input;

    public static void main(String[] args){
        DayOne dayOne = new DayOne();
    }

    public DayOne(){
        InputReader inputReader = new InputReader();
        this.input = inputReader.getCharacters("./src/Input/Day1_Input");
        parseInstructions(input);
    }

    private void parseInstructions(String input){
        int floor = 0;
        int basementPosition = 0;
        boolean basementFound = false;

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') floor++;
            if(input.charAt(i) == ')') floor--;
            if(floor == -1 && !basementFound){
                basementPosition = i + 1;
                basementFound = true;
            }
        }
        System.out.println("Part A = " + floor);
        System.out.println("Part B = " + basementPosition);
    }
}
