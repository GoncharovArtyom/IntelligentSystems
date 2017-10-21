public class Task2 {
    public static void main(String[] args) {
        String s = "Bc .,kjfnbxlxnKJ";
        String res = rot13(s);
        System.out.println(res);

    }
    //Rot13 coding/encoding algorithm
    public static String rot13(String s) {
        String result = "";

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm') {
                result += (char) (c + 13);
            } else if (c >= 'N' && c <= 'Z' || c >= 'n' && c <= 'z') {
                result += (char) (c - 13);
            } else {
                result += c;
            }
        }

        return result;
    }
}
