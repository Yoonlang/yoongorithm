/*

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
import java.util.Set;
import java.util.StringTokenizer;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
           set.add(st.nextToken());
        }

        n = stoi(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            if (set.contains(st.nextToken())) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
