package org.example.tony.D3_22.백양로브레이크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                    continue;
                }
                cost[i][j] = 10000000;
            }
        }

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0])-1;
            int n2 = Integer.parseInt(temp[1])-1;
            int w = Integer.parseInt(temp[2]);

            if (w == 0) {
                cost[n1][n2] = 0;
                cost[n2][n1] = 1;
                continue;
            }
            cost[n1][n2] = 0;
            cost[n2][n1] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            temp = br.readLine().split(" ");
            int q1 = Integer.parseInt(temp[0])-1;
            int q2 = Integer.parseInt(temp[1])-1;

            System.out.println(cost[q1][q2]);
        }
    }
}
