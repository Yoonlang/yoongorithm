package org.example.tony.D3_19.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n+1];
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int next = dp[i - 1] + nums[i - 1];
            answer = Math.max(answer, next);
            dp[i] = Math.max(next , 0);
        }
        System.out.println(answer);
    }
}
