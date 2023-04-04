#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, div = 10007;
    cin >> N;
    vector<vector<int>> map(N + 1, vector<int>(N + 1, 0));
    map[1][1] = 1;
    for (int i = 1; i < N - 1; i++) {
        if (map[i][1] > 0) {
            map[i + 1][1] += 2 * map[i][1];
            map[i + 1][2] += map[i][1];
            map[i + 1][1] %= div;
            map[i + 1][2] %= div;
        }
        for (int j = 2; j <= i; j++) {
            if (map[i][j] > 0) {
                map[i + 1][j] += 2 * map[i][j];
                map[i + 1][j - 1] += map[i][j];
                map[i + 1][j + 1] += map[i][j];
                map[i + 1][j] %= div;
                map[i + 1][j - 1] %= div;
                map[i + 1][j + 1] %= div;
            }
        }
    }
    int res = 0;
    for (int i = 1; i <= N; i++) {
        res += map[N - 1][i];
    }
    cout << ((res * 2) % div);

    return 0;
}
