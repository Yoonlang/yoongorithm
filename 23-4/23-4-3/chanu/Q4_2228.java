import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6 2
-1
3
1
2
4
-1

9
 */
public class Q4_2228 {
    static int[] arr;
    static int[][] sum;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //개수
        int m = Integer.parseInt(st.nextToken()); // 구간 개수

        arr = new int[n + 1];
        sum = new int[n + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            sum[i][i] = arr[i];
            for (int j = i + 1; j < n + 1; j++) {
                sum[i][j] = sum[i][j - 1] + arr[j];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE + 3276800 + 1);
        }

        // 줄이 1일때 처리
        dp[1][1] = sum[1][1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);

                for (int k = 0; k < j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + sum[k + 2][j]);
                }
                if (i == 1) {
                    dp[i][j] = Math.max(dp[i][j], sum[1][j]);
                }
            }
            printDP();
        }

        System.out.println(dp[m][n]);
    }
    
    static void printDP() {
        System.out.println("시작------");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

}
