package org.example.tony.D3_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                pq.add(num);
            } else {
                if (pq.size() == 0) {
                    sb.append(0);
                    sb.append("\n");
                    continue;
                }
                sb.append(pq.poll());
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
