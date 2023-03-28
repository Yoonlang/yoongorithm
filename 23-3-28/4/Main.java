package org.example.tony.D3_28.색종이3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 0 1 2 3 4 5 6 7 8 9
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[101][101];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int p1 = Integer.parseInt(temp[0]);
            int p2 = Integer.parseInt(temp[1]);

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    paper[p2+j][p1+k] = 1;
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (paper[j][i] == 0) continue;
                paper[j][i] += paper[j-1][i];
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int height = Integer.MAX_VALUE;
                for (int k = j; k < 100; k++) {
                    if (paper[i][k] == 0) {
                        break;
                    }
                    height = Math.min(paper[i][k], height);
                    answer = Math.max(answer, (k-j+1)*height);
                }

            }
        }

        System.out.println(answer);
    }
}
