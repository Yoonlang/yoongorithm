package org.example.tony.D4_10.소풍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 4 6 8
 * 1 2
 * 1 3
 * 1 6
 * 2 3
 * 2 6
 * 3 6
 * 4 5
 * 5 6
 *
 * 900 5000
 */

public class Main {
    static boolean[][] friend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int K = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);
        int F = Integer.parseInt(temp[2]);

        friend = new boolean[N+1][N+1];
        List<Integer>[] conn = new List[N+1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }


        for (int i = 0; i < F; i++) {
            temp = br.readLine().split(" ");
            int f1 = Integer.parseInt(temp[0]);
            int f2 = Integer.parseInt(temp[1]);
            conn[f1].add(f2);
            conn[f2].add(f1);
            friend[f1][f2] = true;
            friend[f2][f1] = true;
        }

        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (conn[i].size() < K-1) continue;
            visited[i] = true;
            play(1, K, i, visited);
            if (done) return;
            visited[i] = false;
        }

        System.out.println(-1);
    }

    static boolean done = false;
    static void play(int cur, int max, int prev, boolean[] visited) {
        if (done) return;
        if (cur == max) {
            for (int i = 1; i < visited.length; i++) {
                if (visited[i]) System.out.println(i);
            }
            done = true;
            return;
        }

        for (int i = prev+1; i < visited.length; i++) {
            if (!friend[i][prev] || !isFriend(visited, i)) continue;
            visited[i] = true;
            play(cur+1, max, i, visited);
            visited[i] = false;
        }
    }

    static boolean isFriend(boolean[] visited, int x) {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] && !friend[i][x]) return false;
        }
        return true;
    }
}
