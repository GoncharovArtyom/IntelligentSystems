import java.lang.Math;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(gcd3(5, 10));
    }

    public static int gcd1(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        //a = Math.abs(a);
        //b = Math.abs(b);

        if (b > a) {
            int t = a;
            a = b;
            b = t;
        }

        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }

        return b;
    }

    public static int gcd2(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        //b = Math.abs(b);

        int r = Math.floorMod(a, b);
        while (r != 0) {
            a = b;
            b = r;
            r = Math.floorMod(a, b);
        }

        return b;
    }

    public static int gcd3(int a, int b) {
        if (a == 0) {
            return (b > 0) ? b : -b;
        }
        if (b == 0) {
            return (a > 0) ? a : -a;
        }

        int r = remainder(a, b);
        while (r != 0) {
            a = b;
            b = r;
            r = remainder(a, b);
        }

        return b;
    }

    public static int remainder(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("divisor should't be zero");
        }
        if (b < 0) {
            return remainder(a, -b);
        }
        if (a < 0) {
            int r = remainder(-a, b);
            if (r != 0) {
                r = b - r;
            }
            return r;
        }

        return a % b;
    }
}
