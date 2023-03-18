package org.example.tony.D3_17.불장난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 불은 매 초마다 가로, 세로 그리고 대각선 방향으로 한 타일씩 번진다.
 *
 * 기웅이와 민수는 1초에 아래 방향, 또는 오른쪽 아래 대각선으로만 한 칸을 움직일 수 있다.
 *
 * 처음 불장난을 하던 타일을 제외하고 두 사람이 같은 타일 위에 선다면 두 사람은 부딪혀서 넘어지게 된다. 그리고 뜨거운 맛을 보게 될 것이다.
 *
 * 매 시행마다 아래, 오른쪽 아래 대각선
 *
 * 100C2 => 5000 * 100 * 4
 *
 * 층 별로 만들 수 있는 조합 다 봐야하고, 그 갯수만큼 다음 가능성 있는 곳에 덧셈
 *
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int[][][] lab = new int[N+1][N][N];
        lab[2][0][1] = 1;

        /**
         * 0 1
         * 0 1, 0 2, 1 1, 1 2
         */

        int[] dirJ = new int[]{0, 0, 1, 1};
        int[] dirK = new int[]{0, 1, 0, 1};
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = j+1; k < i; k++) {
                    for (int idx = 0; idx < 4; idx++) {
                        int nJ = j + dirJ[idx];
                        int nK = k + dirK[idx];

                        if (nJ != nK) {
                            lab[i+1][nJ][nK] = (lab[i+1][nJ][nK] + lab[i][j][k])%10007;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                answer += lab[N][i][j];
            }
        }

        System.out.println(answer*2%10007);
    }
}
