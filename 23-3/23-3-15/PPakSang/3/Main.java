package org.example.tony.D3_15.개업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * dp[n] -> n 개 만드는데 걸리는 최소 날
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> values =  new HashSet<>();
        possible(0, M, 0, 0, nums, values);

        boolean[] dp = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

//        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int v : values) {
//            dp[v] = 1;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            for (int v : values) {
//                if (i - v >= 0 && dp[i-v] != Integer.MAX_VALUE) {
//                    dp[i] = Math.min(dp[i], dp[i-v] + 1);
//                }
//            }
//        }
//
//        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
        for (int v : values) {
            if (v == N) {
                System.out.println(1);
                return;
            }
            if (v <= N) {
                q.add(v);
                dp[v] = true;
            }
        }

        int day = 1;
        while (true) {
            int size = q.size();
            if (size == 0) {
                break;
            }
            day++;
            for (int i = 0; i < size; i++) {
                //전날 만든 값
                int prev = q.poll();
                for (int v : values) {
                    if (prev + v > N || dp[prev+v]) {
                        continue;
                    }
                    if (prev + v == N) {
                        System.out.println(day);
                        return;
                    }
                    dp[prev+v] = true;
                    q.add(prev+v);
                }
            }
        }

        System.out.println(-1);
    }

    static void possible(int start, int max, int cnt, int v, int[] nums, Set<Integer> possible) {
        if (v != 0) {
            possible.add(v);
        }
        if (cnt == 2) {
            return;
        }

        for (int i = start; i < max; i++) {
            possible(i+1, max, cnt+1, v + nums[i], nums, possible);
        }
    }
}
