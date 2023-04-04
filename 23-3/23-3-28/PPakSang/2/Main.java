package org.example.tony.D3_28.종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 9
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 0 0 0 1 1 1 -1 -1 -1
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 1 1 1 0 0 0 0 0 0
 * 0 1 -1 0 1 -1 0 1 -1
 * 0 -1 1 0 1 -1 0 1 -1
 * 0 1 -1 1 0 -1 0 1 -1
 */

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
             map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        play(N, 0, 0);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    static int[] answer = new int[3];

    static void play(int N, int x, int y) {
        int num = map[x][y];

        // 0 1 2 3 4 5 6 7 8
        // 0, 0 / 0, 3 / 0, 6
        for (int i = x; i < x+N; i++) {
            for (int j = y; j < y+N; j++) {
                if (map[i][j] != num) {
                    for (int k = 0; k < 3; k++) {
                        play(N/3, x + N/3*k, y);
                        play(N/3, x + N/3*k, y+(N/3));
                        play(N/3, x + N/3*k, y+(N/3)*2);
                    }
                    return;
                }
            }
        }
        answer[num+1]++;
    }

}
