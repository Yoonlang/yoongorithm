package org.example.tony.D3_25.정수제곱근;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 오버플로우 처리
 *
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long val = Long.parseLong(br.readLine());

        long start = 0;
        long end = (1L << 32) - 1;

        long answer = Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start+end)/2;

            long result = mid*mid;
            if (result < 0 || result > val) {
                answer = Math.min(answer, mid);
                end = mid-1;
                continue;
            }
            if (result == val) {
                System.out.println(mid);
                return;
            }

            start = mid+1;
        }

        System.out.println(answer);
    }
}
