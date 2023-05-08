#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

int N, K, L, a, b;
int map[101][101];
tuple<int, int, int> head = {1, 1, 0};
int di[4] = {0, 1, 0, -1};
int dj[4] = {1, 0, -1, 0};
// R, D, L, U
queue<pair<int, int>> snake;

bool move() {
    auto &[a, b, c] = head;
    int xi = a + di[c];
    int xj = b + dj[c];
    if (xi < 1 || xj < 1 || xi > N || xj > N)
        return false;
    if (map[xi][xj] == 2)
        return false;
    if (map[xi][xj] != 1) {
        auto del = snake.front();
        snake.pop();
        map[del.first][del.second] = 0;
    }
    map[xi][xj] = 2;
    a = xi;
    b = xj;
    snake.push({xi, xj});
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    for (int i = 0; i < K; i++) {
        cin >> a >> b;
        map[a][b] = 1;
    }
    map[1][1] = 2;
    snake.push({1, 1});

    cin >> L;
    char c;
    int time = 1, targetTime = -1;
    while (1) {
        if (targetTime == -1 && L > 0) {
            L--;
            cin >> targetTime >> c;
        }
        if (!move())
            break;

        if (targetTime == time) {
            auto &[p, q, r] = head;
            if (c == 'D') {
                r++;
                r %= 4;
            } else {
                r--;
                r = (r + 4) % 4;
            }
            targetTime = -1;
        }
        time++;
    }

    cout << time;

    return 0;
}
