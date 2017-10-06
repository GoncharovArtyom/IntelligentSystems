import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Task7 {
    //First argument - name of the file to open
    //Second - number of lines' repetitions
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.print("Wrong number of arguments. Usage: program \"fileName\" \"numOfRepeats\"");
            return;
        }

        String pathToFileString = args[0];
        int numOfRepeats;
        try {
            numOfRepeats = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            System.err.print(ex.getMessage());
            return;
        }
        Path filePath = Paths.get(pathToFileString);

        //Number of symbols in file
        //char consists of 2 bytes
        long numSymFile = filePath.toFile().length() / 2;

        ArrayList<String> FileLines;
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            if (line == null) {
                throw new RuntimeException("Empty file");
            }
            //I assume that all lines have lengths about the first line's length
            int assumedAverageLineLen = line.length();
            FileLines = new ArrayList<String>((int) (numSymFile / assumedAverageLineLen));

            FileLines.add(line);
            while ((line = reader.readLine()) != null) {
                FileLines.add(line);
            }
        } catch (Exception ex) {
            System.err.print(ex.getMessage());
            return;
        }

        Random random = new Random();

        //Printing result
        for (int i = 0; i < numOfRepeats; ++i) {
            int randInd = random.nextInt(FileLines.size());
            System.out.println(FileLines.get(randInd));
        }
    }
}
