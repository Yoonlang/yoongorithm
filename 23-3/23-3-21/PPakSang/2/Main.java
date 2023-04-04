package org.example.tony.D3_21.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 8 30 4 30
 * 7
 * 9
 * 7
 * 30
 * 2
 * 7
 * 9
 * 25
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]);
        int d = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);
        int c = Integer.parseInt(temp[3]);

        int[] tray = new int[N+k];

        for (int i = 0; i < N; i++) {
            tray[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            tray[N + i] = tray[i];
        }

        int[] sushi = new int[d+1];
        Set<Integer> set = new HashSet<>();
        set.add(c);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            q.add(tray[i]);
            sushi[tray[i]]++;
            set.add(tray[i]);
        }
        int answer = set.size();

        for (int i = k; i < k+N-1; i++) {
            int prev = q.poll();
            int cur = tray[i];
            set.add(cur);
            q.add(cur);
            sushi[cur]++;
            sushi[prev]--;
            if (prev != c && sushi[prev] == 0) {
                set.remove(prev);
            }
            answer = Math.max(answer, set.size());
        }

        System.out.println(answer);
    }
}
