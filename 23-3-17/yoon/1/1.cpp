#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, T;
    cin >> N >> M;
    vector<vector<int>> map(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> map[i][j];
        }
    }

    cin >> T;
    int res = 0;
    for (int i = 0; i < N - 2; i++) {
        for (int j = 0; j < M - 2; j++) {
            vector<int> temp;
            for (int p = i; p < i + 3; p++) {
                for (int q = j; q < j + 3; q++) {
                    temp.push_back(map[p][q]);
                }
            }
            sort(temp.begin(), temp.end());
            if (temp[4] >= T)
                res++;
        }
    }
    cout << res;

    return 0;
}
