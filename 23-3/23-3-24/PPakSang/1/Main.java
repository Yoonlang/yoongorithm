package org.example.tony.D3_24.상근이의여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 2
 * 3 3
 * 1 2
 * 2 3
 * 1 3
 * 5 4
 * 2 1
 * 2 3
 * 4 3
 * 4 5
 *
 * 가장 적은 엣지 -> BFS
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            for (int j = 0; j < M; j++) {
                br.readLine();
            }
            System.out.println(N-1);
        }
    }
}
