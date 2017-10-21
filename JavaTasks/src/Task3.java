import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        String num = "AAA6";
        System.out.println(hexStrToLong(num));
        System.out.println(Long.parseLong(num, 16));
    }

    //Applying standard function
    public static long hexStrToLong(String s) {
        long result = 0;
        long curMult = 1;
        for (int pos = s.length() - 1; pos >= 0; --pos, curMult *= 16) {
            long curTerm = curMult;
            switch (s.charAt(pos)) {
                case '0':
                    curTerm *= 0;
                    break;
                case '1':
                    curTerm *= 1;
                    break;
                case '2':
                    curTerm *= 2;
                    break;
                case '3':
                    curTerm *= 3;
                    break;
                case '4':
                    curTerm *= 4;
                    break;
                case '5':
                    curTerm *= 5;
                    break;
                case '6':
                    curTerm *= 6;
                    break;
                case '7':
                    curTerm *= 7;
                    break;
                case '8':
                    curTerm *= 8;
                    break;
                case '9':
                    curTerm *= 9;
                    break;
                case 'A':
                    curTerm *= 10;
                    break;
                case 'B':
                    curTerm *= 11;
                    break;
                case 'C':
                    curTerm *= 12;
                    break;
                case 'D':
                    curTerm *= 13;
                    break;
                case 'E':
                    curTerm *= 14;
                    break;
                case 'F':
                    curTerm *= 16;
                    break;
                default:
                    throw new RuntimeException("Incorerct input");
            }
            result += curTerm;
        }
        return result;
    }
}
