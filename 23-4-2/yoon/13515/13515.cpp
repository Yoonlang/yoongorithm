#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

int N, M, bucketSize = 300, buIdx = 2;
vector<vector<int>> tree(100001);
vector<int> depth(100001);
vector<int> parent(100001);
vector<int> siz(100001);
vector<int> in(100001);
vector<int> reverseIn(100001);
vector<int> out(100001);
vector<int> top(100001, 1);
vector<int> bottom(100001);
vector<int> bucketIdx(100001);
vector<int> reverseBucketIdx(100001);
vector<bool> isWhite(100001);
vector<pi> seg(400001);

void dfs1(int here, int prev) {
    siz[here] = 1;

    int maxx = -1, maxxIdx = -1;
    for (auto &next : tree[here]) {
        int idx = &next - &tree[here][0];
        if (next == prev) {
            swap(next, tree[here][0]);
            if (maxxIdx == 0)
                maxxIdx = idx;
            continue;
        }

        parent[next] = here;
        depth[next] = depth[here] + 1;

        dfs1(next, here);
        siz[here] += siz[next];
        if (siz[next] > maxx) {
            maxx = siz[next];
            maxxIdx = idx;
        }
    }

    if (maxxIdx != -1)
        swap(tree[here][0], tree[here][maxxIdx]);
}

int idx = 1;
void dfs2(int here, int prev) {
    reverseIn[idx] = here;
    in[here] = idx++;

    for (auto &next : tree[here]) {
        if (next == prev)
            continue;
        int forIdx = &next - &tree[here][0];
        if (forIdx == 0) {
            top[next] = top[here];
            bottom[top[here]] = next;
        } else {
            top[next] = next;
            bottom[next] = next;
            reverseBucketIdx[buIdx] = next;
            bucketIdx[next] = buIdx++;
        }
        dfs2(next, here);
    }

    out[here] = idx;
}

void makeSeg(int r, int s, int e) {
    if (s == e) {
        seg[r].first = out[reverseIn[s]] - s;
        return;
    }

    int m = (s + e) / 2;
    makeSeg(r * 2, s, m);
    makeSeg(r * 2 + 1, m + 1, e);
}

void makeBucket(vector<vector<pi>> &buckets) {
    for (int i = 1; i < buIdx; i++) {
        int totalSize =
            in[bottom[reverseBucketIdx[i]]] - in[top[reverseBucketIdx[i]]] + 1;

        int j = 0;
        while (j < totalSize / bucketSize) {
            buckets[i][j].first = bucketSize;
            j++;
        }
        buckets[i][j].first = totalSize % bucketSize;
    }
}

int getTop(vector<vector<pi>> &buckets, int node, int i, int j) {
    while (1) {
        for (; j >= 0; j--) {
            for (int k = bucketSize - 1; k >= 0; k--) {
                if (isWhite[node] && buckets[i][j].first > 0) {
                    if (!isWhite[reverseIn[in[top[node]] + j * bucketSize +
                                           k]]) {
                        if (in[top[node]] + j * bucketSize + k > in[node])
                            continue;
                        return reverseIn[in[top[node]] + j * bucketSize + k +
                                         1];
                    }
                } else if (!isWhite[node] && buckets[i][j].second > 0) {
                    if (isWhite[reverseIn[in[top[node]] + j * bucketSize +
                                          k]]) {
                        if (in[top[node]] + j * bucketSize + k > in[node])
                            continue;
                        return reverseIn[in[top[node]] + j * bucketSize + k +
                                         1];
                    }
                }
            }
        }

        if (top[node] == 1)
            return 1;

        if (isWhite[parent[top[node]]] != isWhite[node])
            return top[node];

        node = parent[top[node]];
        i = bucketIdx[top[node]];
        j = (in[node] - in[top[node]] + 1) / bucketSize;
        if ((in[node] - in[top[node]] + 1) % bucketSize == 0)
            j--;
    }
}

pi getBucketIdx(vector<vector<pi>> &buckets, int node) {
    int i = bucketIdx[top[node]];
    int j = (in[node] - in[top[node]] + 1) / bucketSize;
    if ((in[node] - in[top[node]] + 1) % bucketSize == 0)
        j--;

    return {i, j};
}

void updateSeg(bool value, int l, int r, int root, int s, int e) {
    if (r < s || l > e)
        return;
    if (l <= s && e <= r) {
        seg[root].first += value ? -1 : 1;
        seg[root].second += value ? 1 : -1;
        return;
    }

    int m = (s + e) / 2;
    updateSeg(value, l, r, root * 2, s, m);
    updateSeg(value, l, r, root * 2 + 1, m + 1, e);
}

pi find(int target, int root, int s, int e) {
    if (target < s || target > e)
        return {0, 0};
    if (target == s && target == e)
        return seg[root];

    seg[root * 2].first += seg[root].first;
    seg[root * 2].second += seg[root].second;
    seg[root * 2 + 1].first += seg[root].first;
    seg[root * 2 + 1].second += seg[root].second;
    seg[root] = {0, 0};

    int m = (s + e) / 2;
    auto l = find(target, root * 2, s, m);
    auto r = find(target, root * 2 + 1, m + 1, e);
    return (l.first + l.second == 0) ? r : l;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N;

    int a, b;
    for (int i = 0; i < N - 1; i++) {
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    dfs1(1, 0);
    dfs2(1, 0);

    makeSeg(1, 1, N);
    bucketIdx[1] = 1;
    reverseBucketIdx[1] = 1;

    vector<vector<pi>> buckets(buIdx, vector<pi>(334));
    makeBucket(buckets);

    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        if (a == 1) {
            int bb = b;
            auto [p, q] = getBucketIdx(buckets, b);
            int t = getTop(buckets, b, p, q);
            while (top[bb] != top[t]) {
                updateSeg(!isWhite[b], in[top[bb]], in[bb], 1, 1, N);
                bb = parent[top[bb]];
            }
            updateSeg(!isWhite[b], in[t], in[bb], 1, 1, N);
            isWhite[b] = !isWhite[b];
            buckets[p][q].first += isWhite[b] ? -1 : 1;
            buckets[p][q].second += isWhite[b] ? 1 : -1;
        } else {
            auto [p, q] = getBucketIdx(buckets, b);
            int t = getTop(buckets, b, p, q);
            pi res = find(in[t], 1, 1, N);
            cout << (isWhite[b] ? res.second : res.first) << '\n';
        }
    }

    return 0;
}
