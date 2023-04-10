package org.example.tony.D4_09.친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] conn = new List[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String r = br.readLine();
            for (int j = 0; j < N; j++) {
                char yn = r.charAt(j);
                if (yn == 'Y') {
                    conn[i].add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, play(i, conn));
        }
        System.out.println(answer);
    }

    static int play(int s, List<Integer>[] conn) {
        boolean[] visited = new boolean[conn.length];
        visited[s] = true;

        int cnt = 0;
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(true) {
            if (cnt == 2) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : conn[cur]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    result++;
                    q.add(next);
                }
            }
            cnt++;
        }
        return result;
    }
}
