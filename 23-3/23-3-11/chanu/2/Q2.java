import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] dp = new int[n+1];
        List<Integer> primes = getPrimes(n);
        dp[0] = 1;

        for (Integer prime : primes) {
            for (int i = prime; i < n + 1; i++) {
                dp[i] = (dp[i] + dp[i - prime]) % 123456789;
            }
        }

        System.out.println(dp[n]);
    }

    private static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        boolean[] candies = new boolean[n+1];
        Arrays.fill(candies, true);
        candies[0] = false;
        candies[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (candies[i]) {
                for (int j = i; j <= n/i; j++) {
                    candies[i*j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (candies[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
