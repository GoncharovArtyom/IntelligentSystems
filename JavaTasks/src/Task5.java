import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.io.File;


public class Task5 {
    public static void main(String[] args){
        String pathToJdkString = "/home/artyom/jdk-9/";
        if (args.length != 0){
            pathToJdkString = args[0];
        }

        String pathToSrcZipString = pathToJdkString + File.separator + "lib" + File.separator + "src.zip";
        Path srcZipPath = Paths.get(pathToSrcZipString);

        try (FileSystem zipfs = FileSystems.newFileSystem(srcZipPath,null)){
            for(Path rootPath : zipfs.getRootDirectories()) {
                String[] wordsToFind = {"transient", "volatile"};
                Files.walk(rootPath)
                        .filter(p->Files.isRegularFile(p))
                        .filter((p)->{
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
