package org.example.tony.D3_16.캡틴이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 0 1 2 3 1 2 3
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[300000];
        int[] arr2 = new int[300000];
        boolean[] possible = new boolean[300001];
        for (int i = 1; i < 300000; i++) {
            arr1[i] = arr1[i-1] + i;
            arr2[i] = arr2[i-1] + arr1[i];
            if (arr2[i] > 300000) {
                break;
            }
            possible[arr2[i]] = true;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        List<Integer> prev = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (possible[i]) {
                prev.add(i);
            }
            int result = Integer.MAX_VALUE;
            for (int s : prev) {
                result = Math.min(dp[i-s], result);
            }
            dp[i] = result+1;
        }

        System.out.println(dp[n]);
    }
}
