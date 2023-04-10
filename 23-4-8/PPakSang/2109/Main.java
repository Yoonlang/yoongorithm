package org.example.tony.D4_08.순회강연;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.concurrent.Callable;

/**
 * 7
 * 20 1
 * 2 1
 * 10 3
 * 100 2
 * 8 2
 * 5 20
 * 50 10
 *
 * 20 1
 * 2 1
 *
 * 100 2
 * 8 2
 *
 * 10 3
 *
 * 50 10
 *
 * 5 20
 *
 * 20
 *
 * 100
 *
 * 3 4 5 6 7 8 9 10
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Tuition> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int p = Integer.parseInt(temp[0]);
            int d = Integer.parseInt(temp[1]);
            pq.add(new Tuition(p, d));
        }

        int[] max = new int[10001];
        while(pq.size() > 0) {
            Tuition t = pq.poll();
            int idx = t.d;

            while (idx >= 1 && t.p <= max[idx]) {
                idx--;
            }

            if (idx <= 0) continue;
            max[idx] = t.p;
        }

        int result = 0;
        for (int n : max) {
            result += n;
        }

        System.out.println(result);
    }

    static class Tuition implements Comparable<Tuition>{
        int p;
        int d;

        public int compareTo(Tuition t) {
            if (t.p == this.p) {
                return t.d - this.d;
            }
            return t.p - this.p;
        }

        Tuition(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}
