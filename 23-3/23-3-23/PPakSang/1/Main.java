package org.example.tony.D3_23.로프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        nums.sort(Comparator.reverseOrder());

        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i)*(i+1));
        }

        System.out.println(max);
    }
}
