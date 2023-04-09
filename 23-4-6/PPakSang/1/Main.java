package org.example.tony.D4_06.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        int[] nums = new int[M];
        StringBuilder sb = new StringBuilder();
        perm(0, M, N, nums, sb);
        System.out.println(sb);
    }

    static void perm(int cur, int max, int N, int[] nums, StringBuilder sb) {
        if (cur == max) {
            for (int num : nums) {
                sb.append(num);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            nums[cur] = i;
            perm(cur+1, max, N, nums, sb);
        }
    }
}
