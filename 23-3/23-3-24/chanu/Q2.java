import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(bf.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = stoi(bf.readLine());
        }


        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            while(!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                sb.append("-\n");
                index += 1;
            }
        }

        if (index == n) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
