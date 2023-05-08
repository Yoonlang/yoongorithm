package org.example.tony.D4_06.문제추천시스템;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 추천
 * 추가
 * 삭제
 *
 * 문제 번호 - 난이도
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Problem> scores = new HashMap<>();
        PriorityQueue<Problem> max = new PriorityQueue<>((p1, p2) -> {
            if (p1.rank == p2.rank) return p2.num - p1.num;
            return p2.rank - p1.rank;
        });

        PriorityQueue<Problem> min = new PriorityQueue<>((p1, p2) -> {
            if (p1.rank == p2.rank) return p1.num - p2.num;
            return p1.rank - p2.rank;
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int num = Integer.parseInt(temp[0]);
            int rank = Integer.parseInt(temp[1]);

            Problem p = new Problem(num, rank);
            max.add(p);
            min.add(p);
            scores.put(num, p);
        }

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            String cmd = temp[0];

            switch (cmd) {
                case "add": {
                    int num = Integer.parseInt(temp[1]);
                    int rank = Integer.parseInt(temp[2]);
                    Problem p = new Problem(num, rank);
                    max.add(p);
                    min.add(p);
                    scores.put(num, p);
                    break;
                }
                case "recommend": {
                    int num = Integer.parseInt(temp[1]);
                    Problem p;
                    if (num == 1) {
                        while ((p = max.peek()).deleted) {
                            max.poll();
                        }
                        sb.append(p.num);
                        sb.append("\n");
                        break;
                    }
                    while ((p = min.peek()).deleted) {
                        min.poll();
                    }
                    sb.append(p.num);
                    sb.append("\n");
                    break;
                }
                case "solved": {
                    int num = Integer.parseInt(temp[1]);
                    scores.get(num).deleted = true;
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int num;
        int rank;
        boolean deleted = false;

        Problem(int num, int rank) {
            this.num = num;
            this.rank = rank;
        }
    }
}
