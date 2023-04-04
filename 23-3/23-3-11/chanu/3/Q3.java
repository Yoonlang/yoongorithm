import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4 2
 * 1 2
 * 3 4
 */

public class Q3 {
    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) == find(b)) {
                count += 1;
            }
            union(a, b);
        }

        for (int i = 2; i <= n; i++) {
            if (find(1) != find(i)) {
                count += 1;
                union(1, i);
            }
        }

        System.out.println(count);
    }
    
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }

        if (rank[x] == rank[y]) {
            rank[x] += 1;
        }
    }
}
