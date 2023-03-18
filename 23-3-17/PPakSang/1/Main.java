package org.example.tony.D3_17.필터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 6 5
 * 49 36 73 62 21
 * 27 88 14 11 12
 * 99 18 36 91 21
 * 45 96 72 12 10
 * 12 48 49 75 56
 * 12 15 48 86 78
 * 40
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int R = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }


        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i <= R-3; i++) {
            for (int j = 0; j <= C-3; j++) {
                List<Integer> values = new ArrayList<>();
                for (int ii = i; ii < i+3; ii++) {
                    for (int jj = j; jj < j+3; jj++) {
                        values.add(map[ii][jj]);
                    }
                }
                values.sort(Comparator.naturalOrder());
                answers.add(values.get(4));
            }
        }

        int T = Integer.parseInt(br.readLine());
        int a = 0;
        for (Integer answer : answers) {
            if (answer >= T) {
                a++;
            }
        }

        System.out.println(a);
    }
}
