#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;
typedef pair<int, int> pi;
typedef tuple<int, int> ti;

const int nmax = 1001, vmax = 1000000001;

int N, M, X, Y, a, b, c;
vector<vector<pi>> graph(nmax);
priority_queue<ti, vector<ti>, greater<>> pq;
vector<int> dist(nmax, vmax);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> N >> M >> X >> Y;
    for (int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }

    pq.push({0, Y});
    while (!pq.empty()) {
        auto [weight, here] = pq.top();
        pq.pop();

        if (dist[here] < weight)
            continue;
        dist[here] = weight;

        for (auto n : graph[here]) {
            auto [next, nw] = n;
            int nextWeight = weight + nw;
            if (dist[next] > nextWeight) {
                dist[next] = nextWeight;
                pq.push({nextWeight, next});
            }
        }
    }

    sort(dist.begin(), dist.begin() + N);
    if (dist[N - 1] == vmax || dist[N - 1] * 2 > X) {
        cout << -1;
        return 0;
    }
    int i = 1, count = 1, walked = 0;
    while (i < N) {
        if (walked + dist[i] * 2 <= X) {
            walked += dist[i] * 2;
            i++;
        } else {
            walked = 0;
            count++;
        }
    }
    cout << count;

    return 0;
}
