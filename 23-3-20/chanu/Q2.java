import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
n s m
3 5 10
5 3 7

10
 */
public class Q2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = stoi(st.nextToken());
        int s = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] musics = new int[n+1];

        for (int i = 1; i <= n; i++) {
            musics[i] = stoi(st.nextToken());
        }

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][s] = s;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (j - musics[i] >= 0 && j + musics[i] <= m && dp[i-1][j-musics[i]] != -1 && dp[i-1][j+musics[i]] != -1) {
                    dp[i][j] = Math.max(dp[i-1][j-musics[i]] + musics[i], dp[i-1][j+musics[i]] - musics[i]);
                } else if (j - musics[i] >= 0 && dp[i-1][j-musics[i]] != -1) {
                    dp[i][j] = dp[i-1][j-musics[i]] + musics[i];
                } else if (j + musics[i] <= m && dp[i-1][j+musics[i]] != -1) {
                    dp[i][j] = dp[i-1][j+musics[i]] - musics[i];
                }
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[n][i] != -1) {
                System.out.println(dp[n][i]);
                return;
            }
        }

        System.out.println(-1);
        
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                System.out.print(dp[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
