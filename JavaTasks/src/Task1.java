import java.lang.Math;

public class Task1 {
    public static int gcd1(int a, int b){
        if (a==0){
            return b;
        }
        if(b == 0){
            return a;
        }
        a = Math.abs(a);
        b = Math.abs(b);

        if(b>a){
            int t = a;
            a = b;
            b = t;
        }

        int r = a%b;
        while (r!= 0){
            a = b;
            b = r;
            r = a%b;
        }

        return b;
    }

    public static int gcd2(int a, int b){
        if (a==0){
            return b;
        }
        if(b == 0){
            return a;
        }

        b = Math.abs(b);

        int r = Math.floorMod(a, b);
        while (r!= 0){
            a = b;
            b = r;
            r = Math.floorMod(a, b);
        }

        return b;
    }
}
