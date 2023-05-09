#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

const int vmax = 100001;
int N, K;
int num[vmax];
int ps[vmax];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> N >> K;
    for (int i = 1; i <= N; i++)
        cin >> num[i];

    for (int i = 1; i <= N; i++)
        ps[i] = num[i] + ps[i - 1];

    int res = INT_MIN;
    for (int i = K; i <= N; i++) {
        res = max(res, ps[i] - ps[i - K]);
    }
    cout << res;

    return 0;
}
