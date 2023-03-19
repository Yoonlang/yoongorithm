#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

pi makeSeg(vector<int> &nums, vector<pi> &seg, int root, int start, int end) {
    if (start == end)
        return seg[root] = {nums[start], 0};

    int mid = (start + end) / 2;
    pi l = makeSeg(nums, seg, root * 2, start, mid);
    pi r = makeSeg(nums, seg, root * 2 + 1, mid + 1, end);
    return seg[root] = {l.first ^ r.first, 0};
}

void query1(vector<int> &nums, vector<pi> &seg, int k, int i, int j, int root,
            int start, int end) {
    if (j < start || i > end)
        return;
    if (i <= start && end <= j) {
        seg[root].second ^= k;
        return;
    }

    if ((min(end, j) - max(start, i) + 1) & 1) {
        seg[root].first ^= k;
    }

    int mid = (start + end) / 2;
    query1(nums, seg, k, i, j, root * 2, start, mid);
    query1(nums, seg, k, i, j, root * 2 + 1, mid + 1, end);
}

int query2(vector<int> &nums, vector<pi> &seg, int i, int j, int root,
           int start, int end) {
    if (j < start || i > end)
        return 0;
    if (i <= start && end <= j) {
        if ((end - start + 1) & 1)
            return seg[root].first ^ seg[root].second;
        else
            return seg[root].first;
    }

    if ((end - start + 1) & 1) {
        seg[root].first ^= seg[root].second;
    }
    seg[root * 2].second ^= seg[root].second;
    seg[root * 2 + 1].second ^= seg[root].second;
    seg[root].second = 0;

    int mid = (start + end) / 2;
    return query2(nums, seg, i, j, root * 2, start, mid) ^
           query2(nums, seg, i, j, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N;
    vector<int> nums(N + 1);
    vector<pi> seg(N * 4);
    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    makeSeg(nums, seg, 1, 1, N);

    cin >> M;
    int a, i, j, k;
    for (int l = 0; l < M; l++) {
        cin >> a >> i >> j;
        i++;
        j++;
        if (a == 1) {
            cin >> k;
            query1(nums, seg, k, i, j, 1, 1, N);
        } else {
            cout << query2(nums, seg, i, j, 1, 1, N) << '\n';
        }
    }

    return 0;
}
