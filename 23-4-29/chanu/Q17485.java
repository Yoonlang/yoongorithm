/*
6 4
5 8 5 1
3 5 8 4
9 77 65 5
2 1 5 2
5 98 1 5
4 95 67 58

29
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17485 {
    static int[][] weights;
    static int n;
    static int m;
    static int[][] dir = {{1,0}, {1,1}, {1,-1}};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        weights = new int[n][m];
        dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                weights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = weights[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (0 > j-dir[k][1]  || j-dir[k][1] >= m) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        continue;
                    }
                    dp[i][j][k] = Math.min(dp[i-dir[k][0]][j-dir[k][1]][(k+1)%3], dp[i-dir[k][0]][j-dir[k][1]][(k+2)%3]) + weights[i][j];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[n-1][i][j]);
            }
        }
        System.out.println(result);
    }


}
