package org.example.tony.D4_01.게임을만든동준이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int cur = nums[N-1];
        for (int i = N-2; i >= 0; i--) {
            if (cur <= nums[i]) {
                answer += nums[i] - cur + 1;
                cur--;
                continue;
            }
            cur = nums[i];
        }

        System.out.println(answer);
    }
}
