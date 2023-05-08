package org.example.tony.D4_02.인사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 3
 * 1 21 79
 * 20 30 25
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cal = new int[2][N];
        for (int i = 0; i < 2; i++) {
             cal[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        play(0, N, cal, 100, 0);
        System.out.println(answer);
    }

    static int answer = Integer.MIN_VALUE;
    static void play(int cur, int max, int[][] cal, int hp, int happy) {
        if (hp <= 0) return;
        if (cur == max) {
            answer = Math.max(answer, happy);
            return;
        }

        play(cur+1, max, cal, hp - cal[0][cur], happy + cal[1][cur]);
        play(cur+1, max, cal, hp, happy);
    }
}
