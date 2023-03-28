#include <algorithm>
#include <cmath>
#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

void dfs1(vector<vector<int>> &tree, vector<int> &size,
          vector<vector<int>> &parent, vector<int> &depth, int here, int prev) {
    size[here] = 1;

    int maxx = -1, maxxIdx = -1;
    for (auto &next : tree[here]) {
        int idx = &next - &tree[here][0];
        if (next == prev) {
            swap(next, tree[here][0]);
            if (maxxIdx == 0)
                maxxIdx = idx;
            continue;
        }

        depth[next] = depth[here] + 1;
        parent[next][0] = here;

        dfs1(tree, size, parent, depth, next, here);
        size[here] += size[next];

        if (size[next] > maxx) {
            maxx = size[next];
            maxxIdx = idx;
        }
    }

    if (maxxIdx != -1)
        swap(tree[here][0], tree[here][maxxIdx]);
}

int idx = 1;

void dfs2(vector<vector<int>> &tree, vector<int> &in, vector<int> &reverseIn,
          vector<int> &out, vector<int> &top, int here, int prev) {
    reverseIn[idx] = here;
    in[here] = idx++;

    for (auto &next : tree[here]) {
        if (next == prev)
            continue;
        int forIdx = &next - &tree[here][0];
        top[next] = forIdx == 0 ? top[here] : next;
        dfs2(tree, in, reverseIn, out, top, next, here);
    }

    out[here] = idx;
}

int sqrtPs;

bool compare(const pi &a, const pi &b) {
    if (a.first / sqrtPs != b.first / sqrtPs)
        return a.first / sqrtPs < b.first / sqrtPs;
    return a.second < b.second;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b;
    cin >> N;

    vector<int> nums(N + 1);
    vector<vector<int>> tree(N + 1);
    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    for (int i = 1; i < N; i++) {
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    vector<int> size(N + 1);
    vector<vector<int>> parent(N + 1, vector<int>(19));
    vector<int> depth(N + 1);
    vector<int> in(N + 1);
    vector<int> reverseIn(N + 1);
    vector<int> out(N + 1);
    vector<int> top(N + 1, 1);

    dfs1(tree, size, parent, depth, 1, 0);
    dfs2(tree, in, reverseIn, out, top, 1, 0);

    for (int i = 1; i <= 18; i++) {
        for (int j = 1; j <= N; j++) {
            parent[j][i] = parent[parent[j][i - 1]][i - 1];
        }
    }

    cin >> M;
    vector<pi> pairs;
    vector<vector<pi>> querys(M);

    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        if (depth[a] > depth[b])
            swap(a, b);
        int aa = a, bb = b;

        int j = 0, diff = depth[b] - depth[a];
        while (diff) {
            if (diff & 1)
                b = parent[b][j];
            j++;
            diff /= 2;
        }

        for (int i = 18; i >= 0; i--) {
            int tempA = parent[a][i];
            int tempB = parent[b][i];
            if (tempA != tempB) {
                a = tempA;
                b = tempB;
            }
        }
        if (a != b) {
            a = parent[a][0];
            b = parent[b][0];
        }

        while (top[a] != top[aa]) {
            pairs.push_back({in[top[aa]], in[aa]});
            querys[i].push_back({in[top[aa]], in[aa]});
            aa = parent[top[aa]][0];
        }
        if (in[a] + 1 <= in[aa]) {
            pairs.push_back({in[a] + 1, in[aa]});
            querys[i].push_back({in[a] + 1, in[aa]});
        }

        while (top[b] != top[bb]) {
            pairs.push_back({in[top[bb]], in[bb]});
            querys[i].push_back({in[top[bb]], in[bb]});
            bb = parent[top[bb]][0];
        }
        pairs.push_back({in[b], in[bb]});
        querys[i].push_back({in[b], in[bb]});
    }

    int ps = pairs.size();
    sqrtPs = sqrt(ps);

    sort(pairs.begin(), pairs.end(), compare);

    int s = pairs[0].first, e = pairs[0].second;

    unordered_map<int, int> res;
    for (int i = s; i <= e; i++) {
        res.insert(nums[reverseIn[i]]);
    }

    for (auto &p : pairs) {
        int idx = &p - &pairs[0];
        if (idx == 0)
            continue;
        cout << p.first << " " << p.second << endl;
    }

    return 0;
}
