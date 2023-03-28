package org.example.tony.D3_28.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int inc = 1;
        int dec = 1;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i-1] <= nums[i]) {
                inc++;
            } else {
                inc = 1;
            }

            if (nums[i-1] >= nums[i]) {
                dec++;
            } else {
                dec = 1;
            }
            answer = Math.max(Math.max(inc, dec), answer);
        }

        System.out.println(answer);
    }
}
