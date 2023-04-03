package org.example.tony.D4_02.다이나믹롤러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] paints = new long[2][N];
        for (int i = 0; i < 2; i++) {
            paints[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            int left = i+1;
            int right = N-1;

            int res = i;
            long paint = paints[0][i];
            while (left <= right) {
                int mid = (left + right) / 2;

                long t = paints[1][mid];
                if (t <= paint) {
                    res = Math.max(res, mid);
                    left = mid + 1;
                    continue;
                }
                right = mid-1;
            }

            sb.append(res-i);
            sb.append(" ");
        }
        sb.append(0);
        System.out.println(sb);
    }
}
