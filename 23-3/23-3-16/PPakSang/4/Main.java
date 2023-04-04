package org.example.tony.D3_16.스크루지민호2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 연결된 노드 수 체크
 *
 * 1개짜리의 부모는 무조건 선택 -> 세운다
 *
 *
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
            String[] temp = br.readLine().split(" ");

            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            conn[n1].add(n2);
            conn[n2].add(n1);
        }

        int[][] dp = new int[N+1][2];
        play(dp, 1, 0, conn);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void play(int[][] dp, int start, int parent, List<Integer>[] conn) {
        dp[start][1] = 1;
        for (int n : conn[start]) {
            if (n != parent) {
                play(dp, n, start, conn);
                dp[start][1] += Math.min(dp[n][0], dp[n][1]);
                dp[start][0] += dp[n][1];
            }
        }
    }
}
