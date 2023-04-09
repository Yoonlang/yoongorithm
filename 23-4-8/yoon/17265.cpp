#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

int N, minn = 1099999, maxx = -1999999;

char map[5][5];

int mult(int a, int b, char opr) {
    switch (opr) {
    case '+':
        return a + b;
    case '-':
        return a - b;
    case '*':
        return a * b;
    }
    return 0;
}

void bfs() {
    queue<tuple<int, int, int, char>> q;
    q.push({1, 0, map[0][0] - '0', '@'});
    q.push({0, 1, map[0][0] - '0', '@'});

    while (!q.empty()) {
        auto [x, y, value, opr] = q.front();
        q.pop();
        if (x >= N || y >= N)
            continue;

        if (opr != '@') {
            value = mult(value, map[x][y] - '0', opr);
            opr = '@';
        } else {
            opr = map[x][y];
        }

        if (x == N - 1 && y == N - 1) {
            minn = min(minn, value);
            maxx = max(maxx, value);
        } else {
            q.push({x + 1, y, value, opr});
            q.push({x, y + 1, value, opr});
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }

    bfs();

    cout << maxx << " " << minn;

    return 0;
}
