package Input;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BJ onB 2015-12-04.
 */
public class InputReader {

    public InputReader(){
    }

    public ArrayList<String> getLines(String filePath) {
        ArrayList<String> input = new ArrayList<String>();
        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNextLine()) {
                input.add(s.nextLine());
            }
            s.close();
        } catch(Exception e) {
            return null;
        }
        return input;
    }

    public String getCharacters(String filePath) {
        String input = "";
        try {
            Scanner s = new Scanner(new File(filePath));
            input = s.useDelimiter("\\A").next();
            s.close();
        } catch (Exception e) {
            return null;
        }
        return input;
    }
}
