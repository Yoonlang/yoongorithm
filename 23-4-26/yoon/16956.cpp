#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int map[501][501];

int N, M;

int di[4] = {0, 0, 1, -1};
int dj[4] = {1, -1, 0, 0};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N >> M;
    string s;
    for (int i = 0; i < N; i++) {
        cin >> s;
        for (int j = 0; j < M; j++) {
            if (s[j] == 'S')
                map[i][j] = 1;
            else if (s[j] == 'W')
                map[i][j] = 2;
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 2) {
                for (int l = 0; l < 4; l++) {
                    int xi = i + di[l];
                    int xj = j + dj[l];
                    if (xi < 0 || xi >= N || xj < 0 || xj >= M)
                        continue;
                    if (map[xi][xj] == 1) {
                        cout << 0;
                        return 0;
                    }
                }
            }
        }
    }

    cout << 1 << endl;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (map[i][j] == 0)
                cout << 'D';
            else if (map[i][j] == 1)
                cout << 'S';
            else
                cout << 'W';
        }
        cout << '\n';
    }

    return 0;
}
