package org.example.tony.D4_01.공주님의정원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 4
 * 1 1 5 31
 * 1 1 6 30
 * 5 15 8 31
 * 6 10 12 10
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Date[] flowers = new Date[N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            int m1 = Integer.parseInt(temp[0]);
            int d1 = Integer.parseInt(temp[1]);
            int m2 = Integer.parseInt(temp[2]);
            int d2 = Integer.parseInt(temp[3]);

            int start = m1*100 + d1;
            int end = m2*100 + d2;

            flowers[i] = new Date(start, end);
        }

        Arrays.sort(flowers, (f1, f2) -> f1.start - f2.start);
        int last = 301;
        int idx = 0;
        int answer = 0;
        while (idx < N) {
            int maxLast = Integer.MIN_VALUE;

            while (idx < N) {
                if (flowers[idx].start <= last) {
                    maxLast = Math.max(maxLast, flowers[idx].end);
                    idx++;
                    continue;
                }
                break;
            }

            answer++;
            if (maxLast >= 1201) {
                System.out.println(answer);
                return;
            }

            if (maxLast == Integer.MIN_VALUE) {
                System.out.println(0);
                return;
            }
            last = maxLast;
        }

        System.out.println(0);
    }

    static class Date {
        int start;
        int end;

        public Date(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
