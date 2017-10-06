import java.util.ArrayList;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        in.useDelimiter("");

        ArrayList<Character> charList = new ArrayList<>();

        long p = 200;
        long x0 = 50;
        long x = 1;
        //polynomial hash functions
        long hash1 = 0;
        long hash2 = 0;
        int len = 0;

        while(in.hasNext()){
            char c = in.next().charAt(0);
            if(c=='\n'){
                continue;
            }
            charList.add(c);
            len++;
            //There are 1 and 2 case in this loop because it's convinient to skip new line symbols in the loop
            // while typing usyng a keyboard.
            if (len == 1){
                System.out.println(true);
                hash1= c;
            } else if(len == 2){
                hash2 = c;
                if(hash1==hash2){
                    System.out.println(isPalindrome(charList));
                }else{
                    System.out.println(false);
                }
            } else {
                if(len%2==1){
                    //it takes O(1) to compute new value
                    hash2 = (((hash2 - (x*charList.get(len/2))%p)*x0)%p + c)%p;
                    //If hash values are the same there is no other way to know if the input is a palindrome
                    //except comparison
                    if(hash1 == hash2){
                        System.out.println(isPalindrome(charList));
                    } else {
                        System.out.println(false);
                    }
                } else{
                    x = (x*x0);
                    //O(1)
                    hash1 = (hash1 + (charList.get(len/2-1)*x)%p)%p;
                    hash2 = ((hash2*x0)%p + c)%p;
                    if(hash1 == hash2){
                        System.out.println(isPalindrome(charList));
                    } else {
                        System.out.println(false);
                    }
                }
            }
        }

    }

    private static boolean isPalindrome(ArrayList<Character> charList) {
        int len = charList.size();
        for (int i = 0; i<len/2; ++i){
            if (charList.get(i) != charList.get(len-1 -i)){
                return false;
            }
        }
        return true;
    }
}
