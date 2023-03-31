import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 4
0000
0010
0000
1001
1011
1001

2
*/
public class Q2_1080 {

    static char[][] arr;
    static char[][] resultArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        resultArr = new char[n][m];
        for (int i = 0; i < n; i++) {
            resultArr[i] = br.readLine().toCharArray();
        }

        if (n <= 2 || m <= 2) {
            if (!Arrays.deepEquals(arr, resultArr)) {
                System.out.println(-1);
                return;
            }

            System.out.println(0);
            return;
        }

        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (arr[i][j] != resultArr[i][j]) {
                    flip(arr, i, j);
                    count += 1;
                }
            }
        }

        if (!Arrays.deepEquals(arr, resultArr)) {
            System.out.println(-1);
            return;
        }

        System.out.println(count);
    }

    public static void flip(char[][] arr, int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (arr[i][j] == '0') {
                    arr[i][j] = '1';
                } else {
                    arr[i][j] = '0';
                }
            }           
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
