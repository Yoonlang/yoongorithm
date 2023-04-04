
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * 2
 * 5 6
 * 0 0 1 0
 *
 * 30
 * 30
 *
 */

public class Q4ttt {

    static int[] opCounts = new int[4];
    static char[] ops = {'+', '-', '*', '/'};

    static List<String> opsResults = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());

        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            opCounts[i] = stoi(st.nextToken());
        }

        dfs(new StringBuilder(), n-1);

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (String ops : opsResults) {
            int value = calString(numbers, ops);
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static int calString(int[] numbers, String ops) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            numStack.push(numbers[i]);
            if (i >= ops.length()) {
                break;
            }

            while(opStack.size() > 0 && getPriority(opStack.peek()) >= getPriority(ops.charAt(i))) {
                int i2 = numStack.pop();
                int i1 = numStack.pop();
                numStack.push(cal(i1, i2, opStack.pop()));
            }
            opStack.push(ops.charAt(i));
        }


        while (!opStack.isEmpty()) {
            int i2 = numStack.pop();
            int i1 = numStack.pop();
            numStack.push(cal(i1, i2, opStack.pop()));
        }
        return numStack.pop();
    }

    static void dfs(StringBuilder sb, int totalOps) {
        if (sb.length() == totalOps) {
            opsResults.add(sb.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opCounts[i] > 0) {
                opCounts[i] -= 1;
                sb.append(ops[i]);

                dfs(sb, totalOps);

                opCounts[i] += 1;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    private static int getPriority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return -1;
    }

    private static int cal(int i1, int i2, char op) {
        if (op == '+') {
            return i1 + i2;
        } else if(op == '-') {
            return i1 - i2;
        } else if (op == '*') {
            return i1 * i2;
        } else if (op == '/') {
            return i1 / i2;
        }

        return -1111111;
    }


}
