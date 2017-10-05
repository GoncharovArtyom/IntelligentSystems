
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: program \"filename\" \"int|double|word|line\"");
            return;
        }

        try (Scanner scanner = new Scanner(Files.newBufferedReader(Paths.get(args[0])))) {
            if (args[1].compareTo("int") == 0) {
                IntStream s = ScannerToIntStream(scanner);
                s.filter(num -> num > 2).forEach(System.out::println);
            } else if (args[1].compareTo("double") == 0) {
                DoubleStream s = ScannerToDoubleStream(scanner);
                s.filter(num -> num > 2).forEach(System.out::println);
            } else if (args[1].compareTo("word") == 0) {
                Stream<String> s = ScannerToWordsStream(scanner);
                s.forEach(System.out::println);
            } else if (args[1].compareTo("line") == 0) {
                Stream<String> s = ScannerToLinesStream(scanner);
                s.forEach(System.out::println);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static IntStream ScannerToIntStream(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            throw new RuntimeException("Empty file");
        }
        int number = scanner.nextInt();
        IntStream stream = IntStream.of(number);
        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            stream = IntStream.concat(stream, IntStream.of(number));
        }
        return stream;
    }

    public static DoubleStream ScannerToDoubleStream(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            throw new RuntimeException("Empty file");
        }
        double number = scanner.nextDouble();
        DoubleStream stream = DoubleStream.of(number);
        while (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
            stream = DoubleStream.concat(stream, DoubleStream.of(number));
        }
        return stream;
    }

    public static Stream<String> ScannerToWordsStream(Scanner scanner) {
        if (!scanner.hasNext()) {
            throw new RuntimeException("Empty file");
        }
        String word = scanner.next();
        Stream<String> stream = Stream.of(word);
        while (scanner.hasNext()) {
            word = scanner.next();
            stream = Stream.concat(stream, Stream.of(word));
        }
        return stream;
    }

    public static Stream<String> ScannerToLinesStream(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            throw new RuntimeException("Empty file");
        }
        String line = scanner.nextLine();
        Stream<String> stream = Stream.of(line);
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            stream = Stream.concat(stream, Stream.of(line));
        }
        return stream;
    }

}
