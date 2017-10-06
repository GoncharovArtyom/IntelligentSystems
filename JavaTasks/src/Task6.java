import java.io.*;

public class Task6 {
    //First argument - name of the file to open
    //Second - symbol what is asked to find
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.print("Wrong number of arguments. Usage: program \"fileName\" \"characterToFind\"");
            return;
        }

        char symToComp;
        if (args[1].length() != 1) {
            System.err.print("Incorrect second argument. Usage: program \"fileName\" \"characterToFind\"");
            return;
        }
        symToComp = args[1].charAt(0);
        int count = 0;

        //Counting number of symbol's occurings
        try (Reader reader = new InputStreamReader(new FileInputStream(args[0]))) {
            int curSym;
            while ((curSym = reader.read()) != -1) {
                if (curSym == symToComp) {
                    count++;
                }
            }
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
        }

        System.out.print(count);
    }
}
