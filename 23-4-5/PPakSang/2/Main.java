package org.example.tony.D4_05.기타콘서트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 4 5
 * GIBSON YYYNN
 * FENDER YYNNY
 * EPIPHONE NNNYY
 * ESP YNNNN
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        guitar = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            long possible = 0;

            for (int j = 0; j < M; j++) {
                char c = temp[1].charAt(j);

                if (c == 'Y') {
                    flag = true;
                    possible = possible | 1L << j;
                }
            }

            guitar.put(i, possible);
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= N; i++) {
            play(0, i, 0, new boolean[N]);
        }
        System.out.println(min);
    }

    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    static Map<Integer, Long> guitar;
    static void play(int cur, int max, int prev, boolean[] selected) {
        if (cur == max) {
            long result = 0;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    result = result | guitar.get(i);
                }
            }

            int cnt = 0;
            for (int i = 0; i < 50; i++) {
                if ((result & (1L<<i)) != 0) {
                    cnt++;
                }
            }

            if (answer > cnt) return;

            if (answer == cnt) {
                if (min > max) {
                    min = max;
                }
                return;
            }

            answer = Math.max(answer, cnt);
            min = max;
            return;
        }

        for (int i = prev; i < selected.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            play(cur+1, max, i+1, selected);
            selected[i] = false;
        }
    }

}
