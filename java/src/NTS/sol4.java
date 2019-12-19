package NTS;

import java.math.*;

public class sol4 {
    public static void main(String[] args) {
        System.out.println(solution(100, 100));
        System.out.println(solution2(10000, 100));
        System.out.println(nPr(31, 15).multiply(nPr(31, 15)).divide(factorial(new BigInteger("15"))).remainder(new BigInteger("10007")));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        if (k <= n) {
            answer = (int) (sol(n, k) % 10007);
            for (int i = n; i > n - k; i--) {
                answer = (answer * i) % 10007;
            }
        }

        return answer;
    }

    // nPr = n(n-1)(n-2)...(n-(r+1))
    // nCr = nPr / r!
    public static long sol(int n, int r) {
        if (r > n) return -1;
        if (r == 0 || n == r) return 1;
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }

    public static BigInteger solution2(int n, int k) {
        return nCr(n, k).multiply(nPr(n, k)).remainder(new BigInteger(Integer.toString(10007)));
    }

    public static BigInteger nCr(int n, int r) {
        BigInteger result = nPr(n, r);
        for (int i = 1; i <= r; i++) {
            result = result.divide(new BigInteger(Integer.toString(i)));
        }

        return result;
    }

    public static BigInteger nPr(int n, int r) {
        return factorial(new BigInteger(Integer.toString(n))).divide(factorial(new BigInteger(Integer.toString(n - r))));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}
