/*

4 4 5
1 2
1 3
2 4
3 4
1 1
1 2
1 3
2 1
1 4

King-God-Emperor


Lier!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q4 {

    static int[] buildingCount;
    static int[] totalParentsCount;
    static int[] curParentsCount;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        totalParentsCount = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            totalParentsCount[end] += 1;
            graph[start].add(end);
        }

        //graphTest(graph, isDependentBuilding, n);

        buildingCount = new int[n+1];
        curParentsCount = new int[n+1];

        boolean result = true;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = stoi(st.nextToken());
            int num = stoi(st.nextToken());

            if (cmd == 1) {
                result = build(num);
            } else {
                result = destroy(num);
            }

            if (!result) {
                System.out.println("Lier!");
                return;
            }
        }
        System.out.println("King-God-Emperor");

    }

    static void graphTest(List<Integer>[] graph, boolean[] isDependentBuilding,int n) {
        for (int i = 0; i < n+1; i++) {
            System.out.println(graph[i].toString());
        }

        for (int i = 0; i < n+1; i++) {
            System.out.print(i);
            System.out.print(" ");
            System.out.println(isDependentBuilding[i]);
        }

    }
    static boolean build(int num) {
        if (curParentsCount[num] != totalParentsCount[num]) {
            return false;
        }
        if (buildingCount[num] == 0) {
            for (int child: graph[num]) {
                curParentsCount[child] += 1;
            }
        }
        buildingCount[num] += 1;

        return true;
    }
    static boolean destroy(int num) {
        if (buildingCount[num] <= 0) {
            return false;
        }

        buildingCount[num] -= 1;

        if (buildingCount[num] == 0) {
            for (int child: graph[num]) {
                curParentsCount[child] -= 1;
            }
        }

        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
