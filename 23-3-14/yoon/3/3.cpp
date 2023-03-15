#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int di[4] = {0, 0, 1, -1};
int dj[4] = {1, -1, 0, 0};

int dfs(vector<vector<int>> &map, int N, int M, int i, int j) {
    if (map[i][j] == 2)
        return 0;

    map[i][j] = 2;
    int sum = 1;
    for (int l = 0; l < 4; l++) {
        int xi = di[l] + i;
        int xj = dj[l] + j;
        if (xi < 1 || xj < 1 || xi > N || xj > M)
            continue;
        if (map[xi][xj] == 2 || map[xi][xj] == 0)
            continue;
        sum += dfs(map, N, M, xi, xj);
    }
    return sum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, K;
    cin >> N >> M >> K;
    vector<vector<int>> map(N + 1, vector<int>(M + 1, 0));
    int a, b;
    for (int i = 0; i < K; i++) {
        cin >> a >> b;
        map[a][b] = 1;
    }

    int res = 0;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (map[i][j] == 1) {
                res = max(res, dfs(map, N, M, i, j));
            }
        }
    }

    cout << res;

    return 0;
}
