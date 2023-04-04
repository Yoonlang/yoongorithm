/*
1
5
4 1 5 2 3
5
1 3 7 9 5

1
1
0
0
1


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q1_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < t; test++) {
            int n = stoi(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(stoi(st.nextToken()));
            }

            int m = stoi(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (set.contains(stoi(st.nextToken()))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
