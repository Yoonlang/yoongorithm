/*
4 3 4
2 5
1 2
3 3
2 1

2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17208 {
    static int n;
    static int a;
    static int b;
    static int[][] bag;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bag = new int[n+1][2];
        dp = new int[n+1][a+1][b+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < a+1; j++) {
                for (int k = 0; k < b+1; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= bag[i][0] && k >= bag[i][1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j - bag[i][0]][k - bag[i][1]] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n][a][b]);
    }
}
