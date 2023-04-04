package org.example.tony.D3_28.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int cur = 1;
        int prev = nums[0];

        while (cur < N && prev == nums[cur]) {
            cur++;
        }

        if (cur == N) {
            System.out.println(cur);
            return;
        }

        boolean upDown = false;
        prev = nums[cur];
        if (nums[cur] < prev) {
            upDown = true;
        }

        int equalCnt = 1;
        int cnt = cur+1;
        for (int i = cur+1; i < N; i++) {
            if (prev == nums[i]) {
                equalCnt++;
                cnt++;
                continue;
            }

            if (upDown) {
                if (prev > nums[i]) {
                    prev = nums[i];
                    equalCnt = 1;
                    cnt++;
                    continue;
                }
                answer = Math.max(answer, cnt);
                cnt = 1+equalCnt;
                equalCnt = 1;
                prev = nums[i];
                upDown = false;
                continue;
            }

            if (prev < nums[i]) {
                prev = nums[i];
                equalCnt = 1;
                cnt++;
                continue;
            }
            answer = Math.max(answer, cnt);
            cnt = 1+equalCnt;
            equalCnt = 1;
            prev = nums[i];
            upDown = true;
        }

        answer = Math.max(answer, cnt);
        System.out.println(answer);
    }
}
