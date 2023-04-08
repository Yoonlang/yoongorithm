#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool map[101][101];

void flip(int a, int b) {
    for (int i = 0; i <= a; i++) {
        for (int j = 0; j <= b; j++) {
            map[i][j] = !map[i][j];
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    string s;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> s;
        for (int j = 0; j < M; j++) {
            map[i][j] = s[j] == '0' ? false : true;
        }
    }

    int res = 0;
    for (int i = N - 1; i >= 0; i--) {
        for (int j = M - 1; j >= 0; j--) {
            if (map[i][j] == true) {
                flip(i, j);
                res++;
            }
        }
    }

    cout << res;
    return 0;
}
