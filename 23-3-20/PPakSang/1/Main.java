package org.example.tony.D3_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 10 5
 * 1 2 3 4 2 5 3 1 1 2
 *
 * 1 3 6 10 12 17
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int total = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (left > right) {
                total = 0;
                right = left;
            }
            if (right == n) {
                break;
            }
            total += nums[right];

            if (total == m) {
                answer++;
                right++;
            } else if (total > m) {
                total -= nums[right];
                total -= nums[left];
                left++;
            } else {
                right++;
            }
        }

        System.out.println(answer);
    }
}
