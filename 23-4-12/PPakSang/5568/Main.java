package org.example.tony.D4_12.카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        perm(0, k, nums, new boolean[N], new int[k]);
        System.out.println(answer.size());
    }

    static int N;
    static Set<Integer> answer = new HashSet<>();
    static void perm(int cur, int max, int[] nums, boolean[] visited, int[] select) {
        if (cur == max) {
            int result = 0;
            for (int s : select) {
                if (s / 10 != 0) {
                    result = result * 100 + s;
                } else {
                    result = result * 10 + s;
                }
            }
            answer.add(result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            select[cur] = nums[i];
            perm(cur+1, max, nums, visited, select);
            visited[i] = false;
        }
    }
}
