import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.File;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

public class Task5 {
    public static void main(String[] args){
        String pathToJdk = "/home/artyom/jdk-9/";
        if (args.length != 0){
            pathToJdk = args[0];
        }

        String pathToSrcZip = pathToJdk + File.separator + "lib" + File.separator + "src.zip";
        Path srcZipPath = Paths.get(pathToSrcZip);

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
