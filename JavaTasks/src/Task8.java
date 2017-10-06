import java.util.stream.Stream;

public class Task8 {
    public static void main(String[] args) {
        Stream<Long> stream = Stream.iterate(1L, Task8::linearCongruentialGenerator);
        stream.limit(1000).forEach(System.out::println);
    }

    static Long linearCongruentialGenerator(Long xn){
        long a = 25214903917L;
        long c = 11L;
        long m = 281474976710656L;

        //There is an overflow problem but I think it's OK - we have negative numbers too now
        return (a*xn + c)%m;
    }
}
