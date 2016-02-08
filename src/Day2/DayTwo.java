package Day2;

import Input.InputReader;

import java.util.ArrayList;

/**
 * Created by BJ on 2015-12-02.
 */
public class DayTwo {
    private ArrayList<String> input;

    public static void main(String[] args){
        DayTwo dayTwo = new DayTwo();
    }

    public DayTwo(){
        InputReader inputReader = new InputReader();
        this.input = inputReader.getLines("./src/Input/Day2_Input");
        parseInstructions(input);
    }

    private void parseInstructions(ArrayList<String> input){
        int l;
        int w;
        int h;
        int smallestSide;
        int paperNeeded = 0;
        int paperNeededForRibbon = 0;
        for(String line : input) {
            l = Integer.parseInt(line.substring(0, line.indexOf("x")));
            w = Integer.parseInt(line.substring(line.indexOf("x") + 1, line.lastIndexOf("x")));
            h = Integer.parseInt(line.substring(line.lastIndexOf("x") + 1, line.length()));
            paperNeededForRibbon +=  (l * w * h);
            paperNeeded += 2*l*w + 2*w*h + 2*h*l;
            //Add extra paper (area of smallest side)
            smallestSide = Math.min(l*w, w*h);
            smallestSide = Math.min(smallestSide, h*l);
            paperNeeded += smallestSide;
            //Add extra paper for bow (2 * each of two shortest dimensions)
            paperNeededForRibbon += 2 * Math.min(l, w);
            paperNeededForRibbon += 2 * Math.min(Math.max(l, w), h);
        }
        System.out.println("Part A = " + paperNeeded);
        System.out.println("Part B = " + paperNeededForRibbon);
    }
}
