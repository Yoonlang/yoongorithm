#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

typedef pair<int, int> pi;
int N, A, B, a, b;

struct HASH {
    size_t operator()(const pair<int, int> &x) const {
        return hash<long long>()(((long long)x.first) ^
                                 (((long long)x.second) << 32));
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    unordered_map<pi, int, HASH> map;

    cin >> N >> A >> B;
    for (int i = 0; i < N; i++) {
        cin >> a >> b;
        map[pair{a, b}]++;
    }

    int res = 0;
    for (auto entry : map) {
        auto [p, n] = entry;
        auto [x, y] = p;
        if (map.find({x + A, y + B}) == map.end() ||
            map.find({x + A, y}) == map.end() ||
            map.find({x, y + B}) == map.end())
            continue;
        res += min({map[pair{x + A, y + B}], map[pair{x, y + B}],
                    map[pair{x + A, y}], map[pair{x, y}]});
    }

    cout << res;

    return 0;
}
