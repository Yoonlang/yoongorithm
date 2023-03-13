package org.example.tony.D3_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 벽이 있으면 오른쪽 끝까지 확인
 * 그 전에 벽을 만나면 카운트 반납
 * visited[true] 는 넘어가기
 */

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int H = Integer.parseInt(temp[0]);
        int W = Integer.parseInt(temp[1]);

        boolean[][] maps = new boolean[H+1][W];
//        boolean[][] visited = new boolean[H][W];

        temp = br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(temp[i]);
            for (int j = 0; j < h; j++) {
                maps[j][i] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (!maps[j][i]) {
                    continue;
                }

                int nX = i;
                int cnt = 0;
                while (nX+1 < W) {
                    nX++;
                    if (maps[j][nX]) {
                        answer += cnt;
                        break;
                    } else {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
