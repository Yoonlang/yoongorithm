package org.example.tony.D3_18.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        br.readLine();
        int[] check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int num : check) {
            int result = bSearch(nums, num);
            if (result >= 0) {
                sb.append("1\n");
                continue;
            }
            sb.append("0\n");
        }

        System.out.println(sb);
    }

    // 1 2 3, 1 1
    static int bSearch(int[] nums, int query) {
        int start = 0;
        int end = nums.length-1;

        int idx = -1;
        while (start <= end) {
            int mid = (start+end)/2;

            if (nums[mid] == query) {
                idx = mid;
                break;
            }
            if (nums[mid] > query) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return idx;
    }
}
