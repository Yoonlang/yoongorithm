package org.example.tony.D3_31.설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, 1500);

        play(0, 0, N, dp);
        System.out.println(dp[N]==1500 ? -1 : dp[N]);
    }

    static void play(int cnt, int amount, int N, int[] dp) {
        if (amount > N) return;
        if (dp[amount] > cnt) dp[amount] = cnt;
        else return;

        play(cnt+1, amount+3, N, dp);
        play(cnt+1, amount+5, N, dp);
    }
}
