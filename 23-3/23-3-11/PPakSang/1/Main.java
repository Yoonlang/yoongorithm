package org.example.tony.D3_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int t = Integer.parseInt(temp[1]);

        Map<String, String> pmDic = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pmDic.put(i+"", name);
            pmDic.put(name, i+"");
        }

        for (int i = 0; i < t; i++) {
            System.out.println(pmDic.get(br.readLine()));
        }
    }
}
