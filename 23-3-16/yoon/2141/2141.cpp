#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<int, ll> pi;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, a, b;
    cin >> N;
    vector<pi> villege(N);
    vector<ll> sum(N + 1, 0);
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        villege[i] = {a, b};
    }
    sort(villege.begin(), villege.end());
    villege.insert(villege.begin(), {0, 0});
    for (int i = 1; i <= N; i++) {
        sum[i] = sum[i - 1] + villege[i].second;
    }
    ll target = (sum[N] + 1) / 2;

    int left = 1, right = N, res;
    while (left <= right) {
        int mid = (left + right) / 2;
        ll l = sum[mid - 1] + 1, r = sum[mid];
        if (l <= target && target <= r) {
            res = mid;
            break;
        } else if (target > r) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    cout << villege[res].first;

    return 0;
}
