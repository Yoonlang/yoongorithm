package org.example.tony.D3_28.캠프준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 3 5 6 1
 * 1 2 3
 *
 * 고를래 말래
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        L = Integer.parseInt(temp[1]);
        R = Integer.parseInt(temp[2]);
        X = Integer.parseInt(temp[3]);

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        play(0, N, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        System.out.println(answer);
    }

    static int L;
    static int R;
    static int X;
    static int answer = 0;
    static int[] nums;
    static void play(int cur, int max, int low, int high, int cnt, int sum) {
        if (cur == max) {
            int diff = high - low;
            if (cnt >= 2 && diff >= X && sum >= L && sum <= R) {
                answer++;
            }
            return;
        }

        play(cur+1, max, Math.min(low, nums[cur]), Math.max(high, nums[cur]), cnt+1, sum+nums[cur]);
        play(cur+1, max, low, high, cnt, sum);
    }
}
