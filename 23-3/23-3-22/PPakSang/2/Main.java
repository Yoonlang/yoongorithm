package org.example.tony.D3_22.밑줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 10
// 10   3  1
// 10   1  5 3
// 10 5 1 3

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int L = Integer.parseInt(temp[1]);

        int length = 0;
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            length += word.length();
            words.add(word);
        }

        int common = (L - length)/(words.size()-1);
        int last = (L - length)%(words.size()-1);

        boolean[] visited = new boolean[N];
        for (int i = 1; i < words.size(); i++) {
            if (last == 0) {
                break;
            }
            String word = words.get(i);

            if (word.charAt(0) < 'a') {
                continue;
            }
            visited[i] = true;
            last--;
        }

        for (int i = words.size()-1; i >= 0; i--) {
            if (last == 0) {
                break;
            }

            if (!visited[i]) {
                visited[i] = true;
                last--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        String underLine = "_".repeat(common);
        String underLine2 = "_".repeat(common+1);
        for (int i = 1; i < N; i++) {
            if (visited[i]) {
                sb.append(underLine2);
            } else {
                sb.append(underLine);
            }
            sb.append(words.get(i));
        }

        System.out.println(sb);
    }
}
