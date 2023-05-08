#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int T, N, M;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_map<int, int> m;

    cin >> T >> N;
    vector<int> a(N);
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    vector<int> sumA(N + 1);
    for (int i = 1; i <= N; i++) {
        sumA[i] = sumA[i - 1] + a[i - 1];
    }
    for (int i = 0; i <= N; i++) {
        for (int j = i + 1; j <= N; j++) {
            m[sumA[j] - sumA[i]]++;
        }
    }
    long long res = 0;
    cin >> M;
    vector<int> b(M);
    for (int i = 0; i < M; i++) {
        cin >> b[i];
    }
    vector<int> sumB(M + 1);
    for (int i = 1; i <= M; i++) {
        sumB[i] = sumB[i - 1] + b[i - 1];
    }
    for (int i = 0; i <= M; i++) {
        for (int j = i + 1; j <= M; j++) {
            res += m[T - sumB[j] + sumB[i]];
        }
    }

    cout << res;

    return 0;
}
