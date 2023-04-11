package org.example.tony.D4_11.블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 5 2
 * 1 4 2 5 1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int X = Integer.parseInt(temp[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;
        int idx = 0;
        while (idx != X) {
            max += nums[idx++];
        }

        int cnt = 1;
        int cur = max;
        for (int i = idx; i < N; i++) {
            int next = cur - nums[i-idx] + nums[i];
            if (next > max) {
                max = next;
                cnt = 1;
            } else if (next == max) {
                cnt++;
            }
            cur = next;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
