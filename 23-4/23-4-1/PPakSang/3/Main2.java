package org.example.tony.D4_01.제곱수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i*i <= N; i++) {
            nums.add(i*i);
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int num : nums) {
                if (i - num < 0) break;
                dp[i] = Math.min(dp[i], dp[i-num]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
