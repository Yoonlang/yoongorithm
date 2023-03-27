#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

void dfs1(vector<vector<pi>> &node, vector<int> &size, vector<int> &depth,
          vector<vector<int>> &parent, vector<int> &parentEdge, int here,
          int prev, int dep) {

    size[here] = 1;

    int maxSize = -1, maxSizeIdx = -1;
    for (int i = 0; i < node[here].size(); i++) {
        auto next = node[here][i];
        if (next.first == prev) {
            swap(node[here][i], node[here][0]);
            continue;
        }
        depth[next.second] = dep + 1;
        parentEdge[next.first] = next.second;
        dfs1(node, size, depth, parent, parentEdge, next.first, here, dep + 1);

        parent[next.second][0] = parentEdge[here];

        size[here] += size[next.first];
        if (size[next.first] > maxSize) {
            maxSize = size[next.first];
            maxSizeIdx = i;
        }
    }
    if (maxSizeIdx != -1)
        swap(node[here][0], node[here][maxSizeIdx]);
}

int idx = 1;

void dfs2(vector<vector<pi>> &node, vector<int> &in, vector<int> &top, int here,
          int prev) {

    for (auto next : node[here]) {
        if (next.first == prev)
            continue;

        in[next.second] = idx++;
        top[next.second] =
            next.second == node[here][0].second
                ? (prev == 0 ? next.second : top[node[prev][0].second])
                : next.second;
        dfs2(node, in, top, next.first, here);
    }
}

int makeSeg(vector<int> &seg, vector<int> &edgeForSeg, int root, int start,
            int end) {
    if (start == end) {
        return seg[root] = edgeForSeg[start];
    }

    int mid = (start + end) / 2;
    return seg[root] =
               max(makeSeg(seg, edgeForSeg, root * 2, start, mid),
                   makeSeg(seg, edgeForSeg, root * 2 + 1, mid + 1, end));
}

int update(vector<int> &seg, int value, int target, int root, int start,
           int end) {
    if (target < start || target > end)
        return seg[root];
    if (target == start && end == target) {
        return seg[root] = value;
    }

    int mid = (start + end) / 2;
    return seg[root] =
               max(update(seg, value, target, root * 2, start, mid),
                   update(seg, value, target, root * 2 + 1, mid + 1, end));
}

int getRes(vector<int> &seg, int left, int right, int root, int start,
           int end) {
    if (left > right || left == 0 || right == 0)
        return 0;
    if (right < start || left > end)
        return 0;
    if (left <= start && end <= right) {
        return seg[root];
    }

    int mid = (start + end) / 2;
    return max(getRes(seg, left, right, root * 2, start, mid),
               getRes(seg, left, right, root * 2 + 1, mid + 1, end));
}

pi find(vector<vector<int>> &parent, int u, int v) {
    for (int i = 18; i >= 0; i--) {
        int tempU = parent[u][i];
        int tempV = parent[v][i];
        if (tempU != tempV) {
            u = tempU;
            v = tempV;
        }
    }
    return {u, v};
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b, c;
    cin >> N;
    vector<vector<pi>> node(N + 1);
    vector<int> parentEdge(N + 1, 0);
    vector<int> size(N + 1);
    vector<int> edge(N);
    vector<int> depth(N);
    vector<int> in(N);
    vector<int> top(N);
    vector<vector<int>> parent(N, vector<int>(19));

    for (int i = 1; i < N; i++) {
        cin >> a >> b >> c;
        edge[i] = c;
        node[a].push_back({b, i});
        node[b].push_back({a, i});
    }

    dfs1(node, size, depth, parent, parentEdge, 1, 0, 0);
    dfs2(node, in, top, 1, 0);

    for (int i = 1; i < 19; i++) {
        for (int j = 1; j < N; j++) {
            parent[j][i] = parent[parent[j][i - 1]][i - 1];
        }
    }

    vector<int> edgeForSeg(N);
    for (int i = 1; i < N; i++) {
        edgeForSeg[in[i]] = edge[i];
    }
    vector<int> seg(N * 4);
    makeSeg(seg, edgeForSeg, 1, 1, N - 1);

    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        if (a == 1) {
            update(seg, c, in[b], 1, 1, N - 1);
        } else {
            int u = parentEdge[b];
            int v = parentEdge[c];

            if (depth[u] > depth[v]) {
                swap(u, v);
                swap(b, c);
            }

            if (top[u] == top[v]) {
                cout << getRes(seg, in[u] + 1, in[v], 1, 1, N - 1) << '\n';
            } else {
                int diff = depth[v] - depth[u];

                int j = 0;
                while (diff) {
                    if (diff % 2) {
                        v = parent[v][j];
                    }
                    j++;
                    diff /= 2;
                }

                if (u == v) {
                    int maxx = 0, bv = parentEdge[c];
                    while (top[bv] != top[u]) {
                        maxx = max(maxx, getRes(seg, in[top[bv]], in[bv], 1, 1,
                                                N - 1));
                        bv = parent[top[bv]][0];
                    }
                    if (bv != u)
                        maxx = max(maxx,
                                   getRes(seg, in[u] + 1, in[bv], 1, 1, N - 1));
                    cout << maxx << '\n';
                } else {
                    auto [p, q] = find(parent, u, v); // u, v가 0은 아님.

                    int maxx = 0, bu = parentEdge[b], bv = parentEdge[c];

                    while (top[p] != top[bu]) {
                        maxx = max(maxx, getRes(seg, in[top[bu]], in[bu], 1, 1,
                                                N - 1));
                        bu = parent[top[bu]][0];
                    }
                    maxx = max(maxx, getRes(seg, in[p], in[bu], 1, 1, N - 1));

                    while (top[q] != top[bv]) {
                        maxx = max(maxx, getRes(seg, in[top[bv]], in[bv], 1, 1,
                                                N - 1));
                        bv = parent[top[bv]][0];
                    }
                    maxx = max(maxx, getRes(seg, in[q], in[bv], 1, 1, N - 1));

                    cout << maxx << '\n';
                }
            }
        }
    }

    return 0;
}
