package org.example.tony.D3_26.행운의문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char[] chars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            chars[i] = word.charAt(i);
        }

        play(0, 'A', chars, new boolean[word.length()]);
        System.out.println(cnt);
    }

    static int cnt = 0;
    static void play(int cur, char prev, char[] chars, boolean[] visited) {
        if (cur == chars.length) {
            cnt++;
            return;
        }

        boolean[] thisVisited = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || prev == chars[i] || thisVisited[chars[i]-'a']) {
                continue;
            }
            thisVisited[chars[i]-'a'] = true;
            visited[i] = true;
            play(cur+1, chars[i], chars, visited);
            visited[i] = false;
        }
    }
}
