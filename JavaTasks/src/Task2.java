public class Task2 {
    public static String Rot13(String s) {
        String result = "";

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
                result+= (char) (c+13);
            } else if (c >= 'N' && c <= 'Z' || c >= 'n' && c <= 'z') {
                result += (char) (c - 13);
            } else {
                result += c;
            }
        }

        return result;
    }
}