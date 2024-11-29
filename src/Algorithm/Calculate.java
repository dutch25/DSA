package Algorithm;
public class Calculate {
    public static int gt(int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        return n * gt(n-1);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 1;
        }
        return n + sum(n-1);
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

}
