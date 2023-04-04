#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

void dfs1(vector<vector<int>> &tree, vector<int> &size, vector<int> &depth,
          vector<int> &parent, int here, int prev) {

    size[here] = 1;

    int maxxIdx = -1, maxx = -1;
    for (auto &next : tree[here]) {
        int idx = &next - &tree[here][0];
        if (next == prev) {
            swap(next, tree[here][0]);
            if (maxxIdx == 0)
                maxxIdx = idx;
            continue;
        }

        depth[next] = depth[here] + 1;
        parent[next] = here;

        dfs1(tree, size, depth, parent, next, here);

        size[here] += size[next];

        if (maxx < size[next]) {
            maxx = size[next];
            maxxIdx = idx;
        }
    }

    if (maxxIdx != -1)
        swap(tree[here][0], tree[here][maxxIdx]);
}

int idx = 1;

void dfs2(vector<vector<int>> &tree, vector<int> &in, vector<int> &out,
          vector<int> &top, int here, int prev) {
    in[here] = idx++;

    for (auto &next : tree[here]) {
        if (next == prev)
            continue;

        int forIdx = &next - &tree[here][0];
        top[next] = forIdx == 0 ? top[here] : next;
        dfs2(tree, in, out, top, next, here);
    }

    out[here] = idx;
}

pi update(vector<pi> &seg, int value, bool toBe, int origin, int target,
          int root, int start, int end) {
    if (target < start || target > end)
        return seg[root];

    if (target == start && end == target)
        return seg[root] = toBe ? pair{value, origin} : pair{INT_MAX, 0};

    int mid = (start + end) / 2;
    auto l = update(seg, value, toBe, origin, target, root * 2, start, mid);
    auto r =
        update(seg, value, toBe, origin, target, root * 2 + 1, mid + 1, end);

    return seg[root] = l.first < r.first ? l : r;
}

pi find(vector<pi> &seg, int left, int right, int root, int start, int end) {
    if (right < start || left > end)
        return {INT_MAX, 0};
    if (left <= start && end <= right)
        return seg[root];

    int mid = (start + end) / 2;
    auto l = find(seg, left, right, root * 2, start, mid);
    auto r = find(seg, left, right, root * 2 + 1, mid + 1, end);
    return l.first < r.first ? l : r;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b;
    cin >> N;
    vector<vector<int>> tree(N + 1);
    for (int i = 1; i < N; i++) {
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    vector<int> in(N + 1);
    vector<int> out(N + 1);
    vector<int> top(N + 1, 1);
    vector<int> size(N + 1);
    vector<int> depth(N + 1);
    vector<int> parent(N + 1);
    vector<bool> color(N + 1); // false : 흰색, true : 검은색

    dfs1(tree, size, depth, parent, 1, 0);
    dfs2(tree, in, out, top, 1, 0);

    vector<pi> seg(N * 4, {INT_MAX, 0});

    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        if (a == 1) {
            color[b] = !color[b];
            update(seg, depth[b], color[b], b, in[b], 1, 1, N);
        } else {
            pi res = {INT_MAX, 0};
            while (top[b] != 1) {
                pi f = find(seg, in[top[b]], in[b], 1, 1, N);
                if (f.first < res.first)
                    res = f;
                b = parent[top[b]];
            }
            pi f = find(seg, in[top[b]], in[b], 1, 1, N);
            if (f.first < res.first)
                res = f;

            if (res.first == INT_MAX)
                cout << -1 << '\n';
            else
                cout << res.second << '\n';
        }
    }

    return 0;
}
