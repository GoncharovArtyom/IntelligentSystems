import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task9 {
    public static void main(String[] args) {
        //Example of usage
        Stream a = Stream.of(0,2,4,6);
        Stream b = Stream.of(1,3,5,7,9,11,13);
        zip(a,b).forEach(System.out::println);
    }
    public static Stream zip(Stream firstStream, Stream secondStream){
        Iterator firstIterator = firstStream.iterator();
        Iterator secondIterator = secondStream.iterator();

        //Iterator that alternates elements from two input streams
        Iterator resultIterator = new Iterator() {
            //Shows what stream next element has to belong
            boolean isFirstNext = true;

            @Override
            public boolean hasNext() {
                if(isFirstNext){
                    return firstIterator.hasNext();
                } else{
                    return secondIterator.hasNext();
                }
            }

            @Override
            public Object next() {
                if (isFirstNext){
                    isFirstNext = false;
                    return firstIterator.next();
                } else {
                    isFirstNext = true;
                    return secondIterator.next();
                }
            }
        };
        //Creating new stream using iterator
        Iterable iterable = ()->resultIterator;
        return StreamSupport.stream(iterable.spliterator(), firstStream.isParallel() || secondStream.isParallel());
    }
}
