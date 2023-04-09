package org.example.tony.D4_07.뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2 2
 * 00
 * 01
 *
 * 가장 오른쪽 아래부터 뒤집기?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m =Integer.parseInt(temp[1]);

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);;
            }
        }

        int answer = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (map[i][j] == '1') {
                    play(i, j, map);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void play(int x, int y, char[][] map) {
        for (int i = x; i >= 0; i--) {
            for (int j = y; j >= 0; j--) {
                map[i][j] = map[i][j] == '1' ? '0' : '1';
            }
        }
    }
}
