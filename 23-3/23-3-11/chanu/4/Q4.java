import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 9
 * 3+8*7-9*2
 *
 * 136
 */

public class Q4 {
    static String s;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());
        s = bf.readLine();
        solve(0, 0);
        System.out.println(result);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void solve(int preValue, int cur) {
        if (s.length() < cur) {
            result = Math.max(result, preValue);
            return;
        }

        int calValue;
        //s[-1] 은 없기에 +로 컨트롤한다
        char preOp = cur == 0 ? '+' : s.charAt(cur - 1);
        //괄호를 친다 (마지막 숫자는 치면 안되기에 if문으로 컨트롤

        if (cur < s.length() - 1) {
            calValue = cal(ctoi(s.charAt(cur)), ctoi(s.charAt(cur + 2)), s.charAt(cur + 1));
            solve(cal(preValue, calValue, preOp), cur + 4);
        }

        //괄호를 안 친다

        solve(cal(preValue, ctoi(s.charAt(cur)), preOp), cur + 2);
    }

    public static int cal(int i1, int i2, char op) {

        if (op == '+') {
            return i1 + i2;
        }
        if (op == '*') {
            return i1 * i2;
        }
        if (op == '-') {
            return i1 - i2;
        }
        return -99999999;
    }

    public static int ctoi(char c) {
        return c - '0';
    }
}