#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N, M, res, t, p;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> p;
    res = p;
    for (int i = 1; i < M; i++) {
        cin >> t;
        res = max(res, (t - p + 1) / 2);
        p = t;
    }
    res = max(res, N - p);

    cout << res;
    return 0;
}
