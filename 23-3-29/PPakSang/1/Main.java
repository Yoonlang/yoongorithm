package org.example.tony.D3_29.PPakSang.연속부분최대곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Double[] nums = new Double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        Double answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i-1]*nums[i], nums[i]);
            answer = Math.max(answer, nums[i]);
        }

        System.out.printf("%.3f", Math.round(answer*1000)/1000.0);
    }
}
