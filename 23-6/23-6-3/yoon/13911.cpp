#include <algorithm>
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<int, int> pi;
typedef tuple<ll, int, int> ti;

const int vmax = 10001;
const ll lmax = (ll)10000 * 300000;

int V, E, a, b, c, M, Md, S, Sd;
vector<vector<pi>> graph(vmax);
int type[vmax];
priority_queue<ti, vector<ti>, greater<>> pq;
vector<vector<ll>> dist(2, vector<ll>(vmax, lmax)); // 0 맥 1 스

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> V >> E;
    for (int i = 0; i < E; i++) {
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
        graph[b].push_back({a, c});
    }

    cin >> M >> Md;
    for (int i = 0; i < M; i++) {
        cin >> a;
        type[a] = 1;
    }

    cin >> S >> Sd;
    for (int i = 0; i < S; i++) {
        cin >> a;
        if (type[a] == 1)
            type[a] = 3;
        else
            type[a] = 2;
    }

    for (int i = 1; i <= V; i++) {
        if (type[i] != 0) {
            pq.push({0, type[i], i});
        }
    }

    while (!pq.empty()) {
        auto [weight, myType, here] = pq.top();
        pq.pop();

        if (myType == 1) {
            if (dist[0][here] < weight)
                continue;
            dist[0][here] = weight;
        } else if (myType == 2) {
            if (dist[1][here] < weight)
                continue;
            dist[1][here] = weight;
        } else {
            if (dist[0][here] < weight || dist[1][here] < weight)
                continue;
            dist[0][here] = weight;
            dist[1][here] = weight;
        }

        for (auto n : graph[here]) {
            auto [next, w] = n;
            int nextWeight = weight + w;
            if (myType == 1) {
                if (dist[0][next] > nextWeight) {
                    dist[0][next] = nextWeight;
                    pq.push({nextWeight, myType, next});
                }
            } else if (myType == 2) {
                if (dist[1][next] > nextWeight) {
                    dist[1][next] = nextWeight;
                    pq.push({nextWeight, myType, next});
                }
            } else {
                if (dist[0][next] > nextWeight && dist[0][next] > nextWeight) {
                    dist[0][next] = nextWeight;
                    dist[1][next] = nextWeight;
                    pq.push({nextWeight, myType, next});
                } else if (dist[0][next] > nextWeight) {
                    dist[0][next] = nextWeight;
                    pq.push({nextWeight, 1, next});
                } else if (dist[1][next] > nextWeight) {
                    dist[1][next] = nextWeight;
                    pq.push({nextWeight, 2, next});
                }
            }
        }
    }

    ll res = lmax;
    for (int i = 1; i <= V; i++) {
        if (type[i] == 0) {
            if (dist[0][i] <= Md && dist[1][i] <= Sd)
                res = min(res, dist[0][i] + dist[1][i]);
        }
    }
    cout << (res == lmax ? -1 : res);

    return 0;
}
