package org.example.tony.D3_23.지름길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 5 150
 * 0 50 10
 * 0 50 20
 * 50 100 10
 * 100 151 10
 * 110 140 90
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int t = Integer.parseInt(temp[1]);

        int[] road = new int[10001];
        for (int i = 0; i < 10001; i++) {
            road[i] = i;
        }

        Map<Integer, List<Path>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);
            int dist = Integer.parseInt(temp[2]);

            if (n2 > t) {
                continue;
            }

            if (!map.containsKey(n1)) {
                map.put(n1, new ArrayList<>());
            }
            map.get(n1).add(new Path(n2, dist));
        }

        PriorityQueue<Position> pq = new PriorityQueue<>((p1, p2)-> p1.w - p2.w);
        pq.add(new Position(0, 0));

        while (pq.size() > 0) {
            Position cur = pq.poll();
            if (cur.p == t) {
                System.out.println(cur.w);
                return;
            }

            int curP = cur.p++;
            int curW = cur.w++;
            pq.add(cur);

            if (!map.containsKey(curP)) {
                continue;
            }


            for (Path p : map.get(curP)) {
                pq.add(new Position(p.to, curW + p.w));
            }
        }
    }

    static class Position {
        int p;
        int w;

        public Position(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }

    static class Path {
        int to;
        int w;

        public Path(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
