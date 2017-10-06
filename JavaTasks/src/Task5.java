import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.io.File;


public class Task5 {
    //First argument - path to jdk
    public static void main(String[] args){
        String pathToJdkString = "/home/artyom/jdk-9/";
        if (args.length != 0){
            pathToJdkString = args[0];
        }

        String pathToSrcZipString = pathToJdkString + File.separator + "lib" + File.separator + "src.zip";
        Path srcZipPath = Paths.get(pathToSrcZipString);

        //Creating file system to iterate over files in src.zip
        try (FileSystem zipfs = FileSystems.newFileSystem(srcZipPath,null)){
            for(Path rootPath : zipfs.getRootDirectories()) {
                String[] wordsToFind = {"transient", "volatile"};
                Files.walk(rootPath)
                        .filter(p->Files.isRegularFile(p)) //Filtering directories
                        .filter((p)->{ //Finding documents that contains specified words
                            try {
                                return containsWords(wordsToFind, p);
                            } catch (IOException ex) {
                                throw new UncheckedIOException(ex);
                            }
                        })
                        .forEach(System.out::println);
            }
        } catch (Exception ex){
            System.err.print(ex.getMessage());
        }
    }

    private static boolean containsWords(String[] words, Path path) throws IOException{
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine())!=null){
                //Checking for every word
                for( String word : words) {
                    if (line.contains(word)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
