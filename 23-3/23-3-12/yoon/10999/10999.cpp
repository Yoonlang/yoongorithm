#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pl;

pl makeSeg(vector<ll> &nums, vector<pl> &seg, int root, int start, int end) {
    if (start == end)
        return seg[root] = {nums[start], 0};

    int mid = (start + end) / 2;
    auto l = makeSeg(nums, seg, root * 2, start, mid);
    auto r = makeSeg(nums, seg, root * 2 + 1, mid + 1, end);
    return seg[root] = {l.first + r.first, 0};
}

void addRange(vector<pl> &seg, ll value, int left, int right, int root,
              int start, int end) {
    if (left > end || right < start)
        return;
    if (left <= start && end <= right) {
        seg[root].second += value;
        return;
    }

    seg[root].first += value * (min(right, end) - max(left, start) + 1);

    int mid = (start + end) / 2;
    addRange(seg, value, left, right, root * 2, start, mid);
    addRange(seg, value, left, right, root * 2 + 1, mid + 1, end);
}

ll getRange(vector<pl> &seg, int left, int right, int root, int start,
            int end) {
    if (left > end || right < start)
        return 0;
    if (left <= start && end <= right) {
        return seg[root].first + seg[root].second * (end - start + 1);
    }

    seg[root].first += seg[root].second * (end - start + 1);
    seg[root * 2].second += seg[root].second;
    seg[root * 2 + 1].second += seg[root].second;
    seg[root].second = 0;

    int mid = (start + end) / 2;
    return getRange(seg, left, right, root * 2, start, mid) +
           getRange(seg, left, right, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K;
    cin >> N >> M >> K;
    vector<ll> nums(N + 1);
    vector<pl> seg(N * 4);

    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    makeSeg(nums, seg, 1, 1, N);

    for (int i = 0; i < M + K; i++) {
        int a, b, c;
        ll d;
        cin >> a >> b >> c;
        if (a == 1) {
            cin >> d;
            addRange(seg, d, b, c, 1, 1, N);
        } else {
            cout << getRange(seg, b, c, 1, 1, N) << '\n';
        }
    }
    return 0;
}
