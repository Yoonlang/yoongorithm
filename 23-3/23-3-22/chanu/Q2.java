/*
9 50
A
quick
brown
fox
jumps
over
the
lazy
dog


A___quick__brown__fox__jumps__over__the__lazy__dog
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int wordNum = stoi(st.nextToken());
        int n = stoi(st.nextToken());
        String[] words = new String[wordNum];

        int charSize = 0;
        for (int i = 0; i < wordNum; i++) {
            words[i] = bf.readLine();
            charSize += words[i].length();
        }

        int underLineNum = (n - charSize) / (wordNum - 1);
        int additionalLine = (n - charSize) % (wordNum - 1);

        boolean[] lineArr = new boolean[wordNum];

        for (int i = 1; i < wordNum; i++) {
            if ('a' <= words[i].charAt(0) && words[i].charAt(0) <= 'z') {
                if (additionalLine > 0) {
                    additionalLine -= 1;
                    lineArr[i] = true;
                }
            }
        }

        for (int i = wordNum - 1; i >= 1; i--) {
            if ('A' <= words[i].charAt(0) && words[i].charAt(0) <= 'Z') {
                if (additionalLine > 0) {
                    additionalLine -= 1;
                    lineArr[i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);

        for (int i = 1; i < wordNum; i++) {
            sb.append("_".repeat(underLineNum));

            if (lineArr[i]) {
                sb.append("_");
            }

            sb.append(words[i]);
        }
        System.out.println(sb.toString());
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
