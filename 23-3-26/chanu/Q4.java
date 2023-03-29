import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7
35 40 50 10 30 45 60
2

240

 */

/**
 * 추가 수정 내용
 * ```java
 * dp[k][i] = max(dp[k-1][i-m] + 현재 칸 사람수 , dp[k-1][i-1])
 * ```
 * 해당 식으로 푸는게 더 낫습니다
 */
public class Q4 {

    static int TRUE = 1;
    static int FALSE = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++){
            arr[i] = stoi(st.nextToken());
        }

        int m = stoi(br.readLine());
        int[] people = new int[n+1-m+1];
        for (int i = 1; i <= n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                people[i] += arr[i + j];
            }
        }

        int[][][] dp = new int[3 + 1][n + 1][2];

        for (int k = 1; k <= 3; k++) {
            for(int i = 1; i <= n-m +1; i++) {
                // O
                if (i >= m) {
                    dp[k][i][TRUE] = Math.max(dp[k-1][i-m][TRUE] + people[i], dp[k-1][i-m][FALSE] + people[i]);
                } else {
                    dp[k][i][TRUE] = people[i];
                }

                // X
                dp[k][i][FALSE] = Math.max(dp[k][i-1][TRUE], dp[k][i-1][FALSE]);

                //printArr(dp);
                //System.out.println();
            }
        }

        System.out.println(Math.max(dp[3][n-m +1][TRUE], dp[3][n-m +1][FALSE]));
    }

    public static void printArr(int[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(Arrays.toString(arr[i][j]));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
