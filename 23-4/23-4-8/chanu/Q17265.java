/*
5
5 + 5 - 3
* 3 - 1 -
4 + 5 + 2
- 2 * 3 -
1 * 5 + 2

127 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17265 {

    static char[][] arr;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0,0,0,'+');
        System.out.print(maxValue);
        System.out.print(" ");
        System.out.print(minValue);
        System.out.println();
    }

    static void dfs(int y, int x, int cur, char op) {

        if (isNumber(arr[y][x])) {
            cur = cal(cur, Character.getNumericValue(arr[y][x]), op);
        } else {
            op = arr[y][x];
        }

        if (isArrived(y, x, arr.length)) {
            maxValue = Math.max(maxValue, cur);
            minValue = Math.min(minValue, cur);
            return;
        }

        int n = arr.length;

        if (y+1 < n && x < n) {
            dfs(y+1, x, cur, op);
        }

        if (y < n && x+1 < n) {
            dfs(y, x+1, cur, op);
        }
    }

    static boolean isNumber(char a) {
        return '0' <= a && a <= '9';
    }

    static boolean isArrived(int y, int x, int n) {
        return y == n - 1 && x == n - 1;
    }

    static int cal(int n1, int n2, char op) {
        int result = 0;
        switch (op) {
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            case '*': return n1 * n2;
            case '/': return n1 / n2;
            default: return Integer.MIN_VALUE;
        }
    }
}
