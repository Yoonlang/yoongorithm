#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, a, b;
    cin >> N;
    int maxx = 2100000000, minn = -2100000000;
    vector<pair<int, int>> v;
    vector<pair<int, int>> neww(N);
    vector<pair<int, int>> oldd(N);

    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        v.push_back({a, b});
    }

    neww[0] = {v[0].first == 0 ? maxx-- : v[0].first,
               v[0].second == 0 ? minn++ : v[0].second};
    oldd[N - 1] = {v[N - 1].first == 0 ? minn++ : v[N - 1].first,
                   v[N - 1].second == 0 ? maxx-- : v[N - 1].second};

    for (int i = 1; i < N; i++) {
        neww[i] = {
            min(neww[i - 1].first, v[i].first == 0 ? maxx-- : v[i].first),
            max(neww[i - 1].second, v[i].second == 0 ? minn++ : v[i].second)};
    }

    for (int i = N - 2; i >= 0; i--) {
        oldd[i] = {
            max(oldd[i + 1].first, v[i].first == 0 ? minn++ : v[i].first),
            min(oldd[i + 1].second, v[i].second == 0 ? maxx-- : v[i].second)};
    }

    int res = -1;
    for (int i = N - 1; i > 0; i--) {
        if ((oldd[i].first < neww[i - 1].first) &&
            (oldd[i].second > neww[i - 1].second)) {
            res = i;
            break;
        }
    }

    cout << res;

    return 0;
}
