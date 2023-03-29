package org.example.tony.D3_29.PPakSang.사회망서비스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 8
 * 1 2
 * 1 3
 * 1 4
 * 2 5
 * 2 6
 * 4 7
 * 4 8
 *
 * 내가 얼리어답터면, 남은 얼리어답터 거나 아니거나
 * 내가 아니면, 남은 무조건 얼리어답터
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] conn = new List[N+1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            String[] temp =  br.readLine().split(" ");

            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn[n1].add(n2);
            conn[n2].add(n1);
        }

        dp = new int[N+1][2];
        play(-1, 1, conn);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static int[][] dp;
    static void play(int parent, int cur, List<Integer>[] conn) {
        dp[cur][1] = 1;

        for (int next : conn[cur]) {
            if (next == parent) continue;
            play(cur, next, conn);
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            dp[cur][0] += dp[next][1];
        }
    }
}