package org.example.tony.D4_01.줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1 3
 * 2 3
 *
 * 내 자식들 다 넣고 나를 넣는다
 */

public class Main {
    static List<Integer> orders;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int n1 = Integer.parseInt(temp[0]);
        int n2 = Integer.parseInt(temp[1]);

        orders = new ArrayList<>();
        visited = new boolean[n1+1];
        List<Integer>[] conn = new List[n1+1];
        for (int i = 0 ; i <= n1; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < n2; i++) {
            temp = br.readLine().split(" ");
            int from = Integer.parseInt(temp[0]);
            int to = Integer.parseInt(temp[1]);

            conn[from].add(to);
        }

        for (int i = 1; i <= n1; i++) {
            if (visited[i]) continue;
            play(i, conn);
        }

        for (int i = n1; i >= 1; i--) {
            System.out.print(orders.get(i-1) + " ");
        }
    }


    static void play(int cur, List<Integer>[] conn) {
        visited[cur] = true;
        for (int next : conn[cur]) {
            if (visited[next]) continue;
            play(next, conn);
        }
        orders.add(cur);
    }
}
