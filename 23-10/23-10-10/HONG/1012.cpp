#include <iostream>
#include <queue>
#include <utility>
using namespace std;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};
int map[51][51];
int vst[51][51];
int T, garo, sero, K;

void bfs(int y, int x) {

    queue<pair<int, int>> q;

    q.push({y, x});
    vst[y][x] = 1;

    while (!q.empty()) {
        int cy = q.front().first;
        int cx = q.front().second;
        q.pop();

        for (int d = 0; d < 4; d++) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if (vst[ny][nx] == 0 && map[ny][nx] == 1 &&
                (0 <= nx && nx < garo) && (0 <= ny && ny < sero)) {
                q.push({ny, nx});
                vst[ny][nx] = 1;
            }
        }
    }
}

void clear() {
    for (int i = 0; i < sero; i++) {
        for (int j = 0; j < garo; j++) {
            vst[i][j] = 0;
            map[i][j] = 0;
        }
    }
}

int main() {

    cin >> T;

    for (int t = 0; t < T; t++) {

        cin >> garo >> sero >> K;

        int x, y;
        for (int k = 0; k < K; k++) {
            cin >> x >> y;
            map[y][x] = 1;
        }

        int ans = 0;
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                if (map[i][j] == 1 && vst[i][j] == 0) {
                    bfs(i, j);
                    ans += 1;
                }
            }
        }

        clear();
        cout << ans << "\n";
    }

    return 0;
}