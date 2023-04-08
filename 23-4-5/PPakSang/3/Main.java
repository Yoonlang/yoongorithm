package org.example.tony.D4_05.나무위의빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 5 20
 * 5 3
 * 3 4
 * 2 1
 * 1 3
 *
 * 1
 * 2  3
 *   4 5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);

        List<Integer>[] conn = new List[N+1];
        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            conn[from].add(to);
            conn[to].add(from);
        }

        double[] waters = new double[N+1];
        waters[1] = W;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        while(q.size() > 0) {
            int cur = q.poll();

            for (int next : conn[cur]) {
                if (visited[next]) continue;

                visited[next] = true;
                if (cur == 1) waters[next] += waters[cur]/(conn[cur].size());
                else waters[next] += waters[cur]/(conn[cur].size()-1);
                q.add(next);
            }
        }

        int cnt = 0;
        double answer = 0;
        for (int i = 2; i <= N; i++) {
            if (conn[i].size() != 1) continue;
            cnt++;
            answer += waters[i];
        }

        System.out.println(answer/cnt);
    }
}
