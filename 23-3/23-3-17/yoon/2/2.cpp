#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, a, b;
    cin >> N >> M;
    vector<int> res(N + 1, 1);
    vector<pi> pre(M);

    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        pre[i] = {a, b};
    }
    sort(pre.begin(), pre.end());
    for (auto p : pre) {
        res[p.second] = max(res[p.second], res[p.first] + 1);
    }

    for (int i = 1; i <= N; i++)
        cout << res[i] << " ";

    return 0;
}
