package org.example.tony.D4_10.선분위의점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 5 5
 * 1 3 10 20 30
 * 1 10
 * 20 60
 * 3 30
 * 2 15
 * 4 8
 *
 * 인덱스 구해서 그 사이 갯수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[] dots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dots);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            temp = br.readLine().split(" ");
            int left = Integer.parseInt(temp[0]);
            int right = Integer.parseInt(temp[1]);

            int lIdx = 0;
            int rIdx = N-1;
            int target = Integer.MAX_VALUE;
            while (lIdx <= rIdx) {
                int mid = (lIdx+rIdx)/2;

                if (dots[mid] >= left) {
                    target = Math.min(target, mid);
                    rIdx = mid-1;
                } else {
                    lIdx = mid+1;
                }
            }

            if (target == Integer.MAX_VALUE) {
                sb.append(0);
                sb.append("\n");
                continue;
            }

            lIdx = 0;
            rIdx = N-1;
            int target2 = Integer.MIN_VALUE;
            while (lIdx <= rIdx) {
                int mid = (lIdx+rIdx)/2;

                if (dots[mid] <= right) {
                    target2 = Math.max(target2, mid);
                    lIdx = mid+1;
                } else {
                    rIdx = mid-1;
                }
            }

            if (target2 == Integer.MIN_VALUE) {
                sb.append(0);
                sb.append("\n");
                continue;
            }

            sb.append(target2-target+1);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
