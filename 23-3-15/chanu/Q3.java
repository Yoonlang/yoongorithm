import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Q3 {

    static Set<Integer> cooks;
    static int[] dp;

    static final int MAX_NUM = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int[] tools = new int[m*2];
        //중복 값이 필요없기에 set
        cooks = new HashSet<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            tools[i] = stoi(st.nextToken());
            cooks.add(tools[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                cooks.add(tools[i] + tools[j]);
            }
        }

        System.out.println(solve(n));
    }
    private static int solve(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, MAX_NUM);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int cookNumber : cooks) {
                if (i >= cookNumber) {
                    dp[i] = Math.min(dp[i], dp[i - cookNumber] + 1);
                }
            }
        }

        return dp[n] == MAX_NUM ? -1 : dp[n];
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
