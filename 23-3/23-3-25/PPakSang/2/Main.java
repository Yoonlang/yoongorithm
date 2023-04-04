package org.example.tony.D3_25.부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 5 0
 * -7 -3 -2 5 8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int t = Integer.parseInt(temp[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        play(0, 0, t, nums);

        System.out.println(t == 0 ? answer - 1 : answer);
    }

    static int answer = 0;
    static void play(int cur, int val, int target, int[] nums) {
        if (cur == nums.length) {
            if (val == target) {
                answer++;
            }
            return;
        }

        play(cur+1, val+nums[cur], target, nums);
        play(cur+1, val, target, nums);
    }
}
