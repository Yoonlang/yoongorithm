package org.example.tony.D3_22.구간합구하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int T = Integer.parseInt(temp[1]);

        temp = br.readLine().split(" ");
        int[] sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(temp[i-1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            temp = br.readLine().split(" ");
            int left = Integer.parseInt(temp[0]);
            int right = Integer.parseInt(temp[1]);
            sb.append(sum[right] - sum[left-1]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
