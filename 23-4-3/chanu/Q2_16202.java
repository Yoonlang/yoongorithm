import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6 6 2
1 2
2 3
1 3
4 5
5 6
4 6

0 0
 */
public class Q2_16202 {
    static Edge[] edges;
    static boolean[] deleted;
    static int[] result;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        edges = new Edge[m + 1];
        deleted = new boolean[m + 1];

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(n1, n2, i);
        }

        int[] result = new int[k];


        for (int i = 0; i < k; i++) {
            root = new int[n+1];

            for (int j = 0; j < n + 1; j++) {
                root[j] = j;
            }

            result[i] = prim(n);
            deleted[i + 1] = true;
        }

        for (int i = 0; i < k; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
        System.out.print("\n");

    }

    public static int prim(int n) {
        int count = 0;

        int totalWeight = 0;
        for (int i = 1; i < edges.length; i++) {
            if (!deleted[i] && union(edges[i].n1, edges[i].n2)) {
                totalWeight += edges[i].w;
                count += 1;
            }
        }

        return count == n - 1 ? totalWeight : 0;
    }

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public static boolean union(int x, int y) {
        if (find(x) == find(y)) {
            return false;
        }
        root[find(y)] = find(x);
        return true;
    }

    static class Edge {
        int n1;
        int n2;
        int w;

        public Edge(int n1, int n2, int w) {
            this.n1 = n1;
            this.n2 = n2;
            this.w = w;
        }
    }

}
