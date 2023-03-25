import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2
1 4
2
3 2

Y N
 */
public class Q4 {

    static final int MAX_VALUE = 40000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());
        int[] knapsack = new int[n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            knapsack[i] = stoi(st.nextToken());
        }

        int m = stoi(bf.readLine());
        int[] marbles = new int[m];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            marbles[i] = stoi(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][2 * MAX_VALUE + 1];
        dp[0][MAX_VALUE] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2 * MAX_VALUE + 1; j++) {
                if (j - knapsack[i] >= 0 && dp[i - 1][j - knapsack[i]]) {
                    dp[i][j] = true;
                }
                if (dp[i - 1][j]){
                    dp[i][j] = true;
                }

                if (j + knapsack[i] <= 2 * MAX_VALUE && dp[i - 1][j + knapsack[i]]) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (dp[n][MAX_VALUE + marbles[i]]) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
        System.out.println();
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
