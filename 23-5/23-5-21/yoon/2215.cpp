#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N, M;
int map[1001][1001];
bool isHang[4][1001][1001];

int di[4] = {1, -1, 0, 0};
int dj[4] = {0, 0, 1, -1};
// 밑 위 우 좌

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    string s;

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> s;
        for (int j = 0; j < M; j++) {
            map[i][j] = s[j] == 'X' ? 0 : 1;
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int l = 0; l < 4; l++) {
                int xi = i + di[l];
                int xj = j + dj[l];
                if (xi < 0 || xi >= N || xj < 0 || xj >= M)
                    continue;
                if (map[i][j] == 0)
                    continue;
                if (map[xi][xj] == 0) {
                    isHang[l][xi][xj] = true;
                }
            }
        }
    }

    int res = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int l = 0; l < 4; l++) {
                if (isHang[l][i][j]) {
                    int xi = i;
                    int xj = j;
                    int yi = i;
                    int yj = j;
                    if (l == 0 || l == 1) {
                        xj += 1;
                        yj -= 1;
                    } else {
                        xi += 1;
                        yi -= 1;
                    }

                    if (xi >= 0 || xi < N || xj >= 0 || xj < M) {
                        if (isHang[l][xi][xj]) {
                            res++;
                            isHang[l][xi][xj] = false;
                            isHang[l][i][j] = false;
                        }
                    }
                    if (yi >= 0 || yi < N || yj >= 0 || yj < M) {
                        if (isHang[l][yi][yj]) {
                            res++;
                            isHang[l][yi][yj] = false;
                            isHang[l][i][j] = false;
                        }
                    }
                }
            }
        }
    }
    cout << res;
    return 0;
}
