package Day6;

import Input.InputReader;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by BJ on 2015-12-06.
 */
public class DaySix {
    int grid[][];

    public static void main (String[] args) {
        InputReader inputReader = new InputReader();
        ArrayList<String> input = inputReader.getLines("./src/Input/Day6_Input");

        DaySix daySixPartA = new DaySix(1000, 1000);
        daySixPartA.parseInstruction(input, "A");
        daySixPartA.howManyLitA();

        DaySix daySixPartB = new DaySix(1000, 1000);
        daySixPartB.parseInstruction(input, "B");
        daySixPartB.howManyLitB();
    }

    public DaySix(int rows, int columns) {
        grid = new int[rows][columns];
        for(int row[] : grid){
            Arrays.fill(row, 0);
        }
    }

    private void parseInstruction(ArrayList<String> input, String option) {
        String instruction;
        int x1;
        int x2;
        int y1;
        int y2;
        for(String line : input) {
            line = line.replace(' ', '-');
            line = line.replace(',', '-');
            String[] result = line.split("-+");
            if(!line.startsWith("tog")){
                instruction = result[1];
                x1 = Integer.parseInt(result[2]);
                y1 = Integer.parseInt(result[3]);
                x2 = Integer.parseInt(result[5]);
                y2 = Integer.parseInt(result[6]);
            }
            else{
                instruction = result[0];
                x1 = Integer.parseInt(result[1]);
                y1 = Integer.parseInt(result[2]);
                x2 = Integer.parseInt(result[4]);
                y2 = Integer.parseInt(result[5]);
            }
            if(instruction.equals("on")) {
                if(option.equals("A")) onA(x1, x2, y1, y2);
                if(option.equals("B")) onB(x1, x2, y1, y2);
            }
            if(instruction.equals("off")) {
                if(option.equals("A")) offA(x1, x2, y1, y2);
                if(option.equals("B")) offB(x1, x2, y1, y2);
            }
            if(instruction.equals("toggle")) {
                if(option.equals("A")) toggleA(x1, x2, y1, y2);
                if(option.equals("B")) toggleB(x1, x2, y1, y2);
            }
        }
    }

    private void howManyLitA() {
        int count = 0;
        for(int row[] : grid){
            for(int light : row){
                count += light;
            }
        }
        System.out.println("Part A = " + count);
    }

    private void howManyLitB() {
        int count = 0;
        for(int row[] : grid){
            for(int light: row){
                count += light;
            }
        }
        System.out.println("Part B = " + count);
    }

    public void printGrid() {
        for(int row[] : grid){
            for(int i = 0; i< row.length; i++){
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }

    public void toggleA(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                if(grid[xPos][yPos] == 0) grid[xPos][yPos] = 1;
                else grid[xPos][yPos] = 0;
            }
        }
    }

    public void toggleB(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                grid[xPos][yPos] += 2;
            }
        }
    }

    public void onA(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                grid[xPos][yPos] = 1;
            }
        }
    }

    public void onB(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                grid[xPos][yPos]++;
            }
        }
    }

    public void offA(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                grid[xPos][yPos] = 0;
            }
        }
    }

    public void offB(int x1, int x2, int y1, int y2) {
        for(int xPos = x1; xPos <= x2; xPos++){
            for(int yPos = y1; yPos <= y2; yPos++){
                if(grid[xPos][yPos] > 0) grid[xPos][yPos]--;
            }
        }
    }
}
