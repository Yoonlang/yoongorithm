package org.example.tony.D3_24.캐빈베이컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * 5 5
 * 1 3
 * 1 4
 * 4 5
 * 4 3
 * 3 2
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 101);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0])-1;
            int n2 = Integer.parseInt(temp[1])-1;

            dist[n1][n2] = 1;
            dist[n2][n1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += dist[i][j];
            }

            if (sum < result) {
                result = sum;
                answer = i;
            }
        }

        System.out.println(answer+1);
    }
}
