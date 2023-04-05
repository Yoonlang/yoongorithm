package org.example.tony.D4_03.구간나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        dp = new int[N][M+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -4000000);
        }
        System.out.println(play(0, nums, M));
    }

    static int[][] dp;
    static int play(int start, int[] nums, int M) {
        if (M == 0) return 0;
        if (start >= nums.length) return -3276800;
        if (dp[start][M] != -4000000) return dp[start][M];

        int sum = 0;
        dp[start][M] = play(start+1, nums, M);
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            int res = sum + play(i+2, nums, M-1);
            if (res > dp[start][M]) {
                dp[start][M] = res;
            }
        }
        return dp[start][M];
    }
}
