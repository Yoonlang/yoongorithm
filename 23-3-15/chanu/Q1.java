import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1 {
    static final int T = 0;
    static final int VALUE = 1;
    static int[] dp;

    public static int reserve(int[][] counseling, int i) {
        if (i >= counseling.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        if (i + counseling[i][T] <= counseling.length) {
            dp[i] =  Math.max(reserve(counseling, i + 1), reserve(counseling, i + counseling[i][T]) + counseling[i][VALUE]);
            return dp[i];
        }
        return reserve(counseling, i + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());

        int[][] counseling = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            counseling[i][T] = stoi(st.nextToken());
            counseling[i][VALUE] = stoi(st.nextToken());
        }

        dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(reserve(counseling, 0));
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
