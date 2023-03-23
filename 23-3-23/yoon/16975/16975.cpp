#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pi;

pi makeSeg(vector<int> &nums, vector<pi> &seg, int root, int start, int end) {
    if (start == end) {
        return seg[root] = {nums[start], 0};
    }

    int mid = (start + end) / 2;
    auto l = makeSeg(nums, seg, root * 2, start, mid);
    auto r = makeSeg(nums, seg, root * 2 + 1, mid + 1, end);
    return seg[root] = {l.first + r.first, 0};
}

void query1(vector<pi> &seg, ll k, int left, int right, int root, int start,
            int end) {
    if (right < start || left > end)
        return;
    if (left <= start && end <= right) {
        seg[root].second += k;
        return;
    }

    seg[root].first += k * (min(right, end) - max(left, start) + 1);
    int mid = (start + end) / 2;
    query1(seg, k, left, right, root * 2, start, mid);
    query1(seg, k, left, right, root * 2 + 1, mid + 1, end);
}

void query2(vector<pi> &seg, int target, int root, int start, int end) {
    if (target < start || target > end)
        return;
    if (target == start && target == end) {
        seg[root].first += seg[root].second;
        seg[root].second = 0;
        cout << seg[root].first << '\n';
        return;
    }

    int mid = (start + end) / 2;
    seg[root].first += (end - start + 1) * seg[root].second;
    seg[root * 2].second += seg[root].second;
    seg[root * 2 + 1].second += seg[root].second;
    seg[root].second = 0;
    query2(seg, target, root * 2, start, mid);
    query2(seg, target, root * 2 + 1, mid + 1, end);
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

    int a, b, c, d;
    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        if (a == 1) {
            cin >> c >> d;
            query1(seg, d, b, c, 1, 1, N);
        } else {
            query2(seg, b, 1, 1, N);
        }
    }

    return 0;
}
