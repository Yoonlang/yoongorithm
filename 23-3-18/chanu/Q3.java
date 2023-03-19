/*
3 310
50 40
100 70
200 150

220
 */

import javax.security.auth.Subject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = stoi(st.nextToken());
        int t = stoi(st.nextToken());

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(10000000, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            subjects.add(new Subject(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        int[][] dp = new int[t+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int time = 1; time <= t; time++) {
                if (time - subjects.get(i).time < 0) {
                    dp[time][i] = dp[time][i-1];
                    continue;
                }
                dp[time][i] = Math.max(dp[time - subjects.get(i).time][i-1] + subjects.get(i).value, dp[time][i-1]);
            }
        }
//
//        for (int i = 0; i < t+1; i++) {
//            for (int j = 0; j < n+1; j++) {
//                System.out.print(dp[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[t][n]);

    }


    static class Subject {
        int time;
        int value;

        public Subject(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
