package org.example.tony.D4_09.원자의에너지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 각각의 원자가 양성자를 얻어서 다음 원자로
 * 2 4 6
 * 2 3
 *
 * 이때, 컨테이너 안에 들어간 원자들이 서로 같은 에너지 상태에 있거나,
 * 어떤 한 개의 원자가 한 개의 양성자를 받아들이거나 내쏘아서 다른 원자와 같은 에너지 상태에 도달할 수 있다면,
 * 이 경우는 실험에서 위험이 발생할 수 있다. 따라서 이러한 경우는 허용되지 않는데,
 * 그러면서도 컨테이너 안의 원자들의 에너지들의 총 합이 최대가 되도록 하려 한다.
 *
 * 2 4 6
 *
 * 2 4
 * 2 4 6
 * 4 6
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        dp = new int[1000001][2];
        atom = new HashSet<>();
        int start = -1;
        for (int i = 0; i < N; i++) {
            int e = Integer.parseInt(br.readLine());
            start = e;
            atom.add(e);
        }
        energy = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            int e = Integer.parseInt(br.readLine());
            energy.add(e);
        }

        play(start, new boolean[1000001]);
        System.out.println(Math.max(dp[start][1], dp[start][0]));
    }

    static int[][] dp;
    static Set<Integer> atom;
    static List<Integer> energy;
    static void play(int s, boolean[] visited) {
        visited[s] = true;
        dp[s][1] = s;
        for (int e : energy) {
            if (atom.contains(s - e) && !visited[s-e]) {
                play(s - e, visited);
                dp[s][1] += dp[s-e][0];
                dp[s][0] += Math.max(dp[s-e][0], dp[s-e][1]);
            }
            if (atom.contains(s + e) && !visited[s+e]) {
                play(s + e, visited);
                dp[s][1] += dp[s+e][0];
                dp[s][0] += Math.max(dp[s+e][0], dp[s+e][1]);
            }
        }
    }
}
