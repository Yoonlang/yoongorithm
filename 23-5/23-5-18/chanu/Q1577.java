import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6 6
2
0 0 0 1
6 6 5 6

252
 */
public class Q1577 {

    static int[][][] map;
    static long[][] dp;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1][2];
        dp = new long[n+1][m+1];
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            if (y2 < y1) {
                int temp = y2;
                y2 = y1;
                y1 = temp;
            }
            if (x2 < x1) {
                int temp = x2;
                x2 = x1;
                x1 = temp;
            }

            if (y2 - y1 > 0 ) {
                map[y1][x1][0] = 1; // 위로
            }
            if (x2 - x1 > 0 ) {
                map[y1][x1][1] = 1;  // 옆으로
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i != n && map[i][j][0] != 1) {
                    dp[i+1][j] += dp[i][j];
                }
                if (j != m && map[i][j][1] != 1) {
                    dp[i][j+1] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
