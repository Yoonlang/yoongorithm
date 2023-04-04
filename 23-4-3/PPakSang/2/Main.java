package org.example.tony.D4_03.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2 3 1
 *
 * 2*2
 * 4*4
 * 8*8
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = (int)Math.pow(2, Integer.parseInt(temp[0]));
        tR = Integer.parseInt(temp[1]);
        tC = Integer.parseInt(temp[2]);

        play(0, 0, N);
    }

    static int cnt = 0;
    static int[] dirX = new int[]{0, 0, 1, 1};
    static int[] dirY = new int[]{0, 1, 0, 1};
    static int tR;
    static int tC;

    // 0 8 0~3
    static void play(int r, int c, int N) {
        if (!inRange(r, c, N)) {
            cnt += N*N;
            return;
        }

        if (N == 2) {
            for (int i = 0; i < 4; i++) {
                int nX = r + dirX[i];
                int nY = c + dirY[i];

                cnt++;
                if (nX == tR && nY == tC) {
                    System.out.println(cnt-1);
                    return;
                }
            }
            return;
        }

        play(r, c, N/2);
        play(r, c + N/2, N/2);
        play(r + N/2, c, N/2);
        play(r + N/2, c + N/2, N/2);
    }

    static boolean inRange(int x, int y, int N) {
        if (tR >= x && tR < x+N && tC >= y && tC < y+N) return true;
        return false;
    }
}
