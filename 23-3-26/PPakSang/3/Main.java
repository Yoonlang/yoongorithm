package org.example.tony.D3_26.입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 10 8
 * 7
 * 3
 * 16
 * 5
 * 18
 * 2
 * 13
 * 12
 * 10
 * 17
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[] table = new int[N];
        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }

        // 1 000 000 000
        // 1
        // 1 000 000 000
        long left = 1L;
        long right = 1_000_000_000L * 1_000_000_000;

        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left+right)/2;

            long result = 0L;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                result += mid/table[i];
                if (result < 0) {
                    flag = true;
                    break;
                }
            }

            if (result >= M || flag) {
                answer = Math.min(answer, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        System.out.println(answer);
    }
}
