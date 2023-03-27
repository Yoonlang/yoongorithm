package org.example.tony.D3_26.로마숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static boolean[][] dp;
    static int cnt = 0;
    static int[] nums = new int[]{1, 5, 10, 50};
    static Set<Integer> answer = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new boolean[N+1][N*50+1];
        play(0, N, 0);
        System.out.println(answer.size());
    }

    static void play(int cur, int max, int prev) {
        if (dp[cur][prev]) {
            return;
        }
        dp[cur][prev] = true;
        if (cur == max) {
            answer.add(prev);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            play(cur+1, max, prev+nums[i]);
        }
    }
}
