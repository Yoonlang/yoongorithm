import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
3
0 2 3
2 0 1
3 1 0

3
 */

public class Q3 {

    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                if (j > i) {
                    edges.add(new Edge(i, j, stoi(st.nextToken())));
                } else {
                    st.nextToken();
                }
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);
        long total = 0;
        for (Edge edge : edges) {
            if (union(edge.n1, edge.n2)){
                total += edge.weight;
            }
        }

        System.out.println(total);
    }

    static class Edge implements Comparable<Edge>{
        int n1;
        int n2;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

        public Edge(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }

        @Override
        public String
        toString() {
            return "Edge{" +
                    "n1=" + n1 +
                    ", n2=" + n2 +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int find(int x) {
        if (x == parent[x]) {  // 루트는 -이기 떄문에
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x1, int x2) {
        int r1 = find(x1);
        int r2 = find(x2);

        if (r1 == r2) {
            return false;
        }
        parent[r1] = r2;
        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
