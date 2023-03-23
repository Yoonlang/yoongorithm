#include <climits>
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int> ti;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, D, a, b, c;
    cin >> N >> D;
    vector<vector<ti>> path(D + 1);
    vector<int> dist(D + 1, INT_MAX);
    path[0].push_back({D, D});
    for (int i = 0; i < N; i++) {
        cin >> a >> b >> c;
        if (b <= D)
            path[a].push_back({b, c});
    }

    for (int i = 0; i < D; i++) {
        path[i].push_back({i + 1, 1});
    }

    priority_queue<ti, vector<ti>, greater<>> pq;
    pq.push({0, 0});

    while (!pq.empty()) {
        auto [weight, here] = pq.top();
        pq.pop();

        if (dist[here] < weight)
            continue;
        dist[here] = weight;

        for (auto p : path[here]) {
            auto [next, val] = p;
            if (dist[next] <= weight + val)
                continue;
            dist[next] = weight + val;
            pq.push({dist[next], next});
        }
    }

    cout << dist[D];

    return 0;
}
