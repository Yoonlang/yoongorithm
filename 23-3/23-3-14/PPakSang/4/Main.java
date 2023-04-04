package org.example.tony.D3_14.양구출작전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 어차피 유일한 길 보장 -> 들어오는 곳에서 나가는 곳이 정해져 있다
 *
 * 내가 1까지 가는 곳에 늑대가 몇 명 있었는가
 *
 * 5
 * 30 20 10
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Node>[] conn = new List[N+1];

        for (int i = 0; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            String[] temp = br.readLine().split(" ");
            String typeStr = temp[0];
            int num = Integer.parseInt(temp[1]);
            int node = Integer.parseInt(temp[2]);

            boolean type = typeStr.equals("S");
            conn[node].add(new Node(type, num, i));
        }

        long result = play(1, conn, new Node(false, 0, 1));
        System.out.println(Math.max(result, 0));
    }

    static long play(int cur, List<Node>[] conn, Node curNode) {
        long result = curNode.type ? curNode.num : -curNode.num;
        for (Node node : conn[cur]) {
            long res = play(node.nNum, conn, node);
            if (res > 0) {
                result += res;
            }
        }
        return result;
    }


    static class Node {
        boolean type; //양이면 true
        int num;
        int nNum;

        public Node(boolean type, int num, int nNum) {
            this.type = type;
            this.num = num;
            this.nNum = nNum;
        }
    }
}
