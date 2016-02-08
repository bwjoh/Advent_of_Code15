package Day3;

import Input.InputReader;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by BJ on 2015-12-03.
 */
public class DayThree {
    private Collection<Point> visitedPoints;
    private Point currentPoint;
    private int santaX;
    private int santaY;
    private int roboX;
    private int roboY;

    public static void main(String[] args){
        DayThree dayThreeA = new DayThree("A");
        DayThree dayThreeB = new DayThree("B");
    }

    public DayThree(String option) {
        InputReader inputReader = new InputReader();
        String input = inputReader.getCharacters("./src/Input/Day3_Input");
        visitedPoints = new HashSet<Point>();
        visitedPoints.add(new Point(0, 0));
        if(option.equals("A")) partA(input);
        if(option.equals("B")) partB(input);
    }

    private void partA(String input) {
        for(int i = 0; i < input.length(); i++){
            move(input.charAt(i), true);
            currentPoint = new Point(santaX, santaY);
            visitedPoints.add(currentPoint);
        }
        System.out.println("Part A = " + visitedPoints.size());
    }

    private void partB(String input) {
        for(int i = 0; i < input.length(); i++){
            if(i % 2 == 0){
                move(input.charAt(i), true);
                currentPoint = new Point(santaX, santaY);
                visitedPoints.add(currentPoint);
            }
            else{
                move(input.charAt(i), false);
                currentPoint = new Point(roboX, roboY);
                visitedPoints.add(currentPoint);
            }
        }
        System.out.println("Part B = " + visitedPoints.size());
    }

    private void move(Character direction, boolean isSanta) {
        switch(direction) {
            case '<':
                if(isSanta) this.santaX -= 1;
                else this.roboX -=1;
                break;
            case '>':
                if(isSanta) this.santaX += 1;
                else this.roboX += 1;
                break;
            case '^':
                if(isSanta) this.santaY += 1;
                else this.roboY += 1;
                break;
            case 'v':
                if(isSanta) this.santaY -= 1;
                else this.roboY -= 1;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
