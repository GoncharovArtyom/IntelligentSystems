import java.io.FileInputStream;
import java.nio.file.*;

public class Task4 {
    public static void main(String[] args){
        try{
            return;
        } catch (Throwable e){
            throw new RuntimeException();
        } finally {
            System.out.print("Hello");
        }
    }

}
