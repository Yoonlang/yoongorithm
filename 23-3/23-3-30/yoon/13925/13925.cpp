// 참고 https://justicehui.github.io/ps/2019/06/14/BOJ13925/
#include <algorithm>
#include <iostream>
#include <tuple>
#include <vector>

#define MOD 1000000007
using namespace std;

typedef long long ll;
typedef pair<ll, ll> pi;

int list[100001];
ll seg[400001];
pi lazy[400001];

ll makeSeg(int root, int start, int end) {
    if (start == end)
        return seg[root] = list[start];

    int mid = (start + end) / 2;
    return seg[root] = (makeSeg(root * 2, start, mid) +
                        makeSeg(root * 2 + 1, mid + 1, end)) %
                       MOD;
}

void updateLazy(int root, int start, int end) {
    auto &here = lazy[root];
    if (here.first == 1 && here.second == 0)
        return;
    if (start != end) {
        for (int i = root * 2; i <= root * 2 + 1; i++) {
            auto &next = lazy[i];
            next.first = (here.first * next.first) % MOD;
            next.second = (here.second + here.first * next.second) % MOD;
        }
    }

    seg[root] =
        (here.first * seg[root] + (end - start + 1) * here.second) % MOD;
    here = {1, 0};
}

void update(int left, int right, int root, int start, int end, int mult,
            int add) {
    updateLazy(root, start, end);
    if (right < start || left > end)
        return;
    if (left <= start && end <= right) {
        auto &here = lazy[root];
        here.first *= mult;
        here.first %= MOD;
        here.second *= mult;
        here.second %= MOD;
        here.second += add;
        here.second %= MOD;
        updateLazy(root, start, end);
        return;
    }

    int mid = (start + end) / 2;
    update(left, right, root * 2, start, mid, mult, add);
    update(left, right, root * 2 + 1, mid + 1, end, mult, add);
    seg[root] = (seg[root * 2] + seg[root * 2 + 1]) % MOD;
}

ll getResult(int left, int right, int root, int start, int end) {
    updateLazy(root, start, end);
    if (right < start || left > end)
        return 0;
    if (left <= start && end <= right)
        return seg[root] % MOD;

    int mid = (start + end) / 2;
    return (getResult(left, right, root * 2, start, mid) +
            getResult(left, right, root * 2 + 1, mid + 1, end)) %
           MOD;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b, c, d;
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> list[i];

    makeSeg(1, 1, N);
    for (int i = 1; i <= 400000; i++)
        lazy[i].first = 1;

    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        if (a == 4) {
            cout << getResult(b, c, 1, 1, N) << '\n';
        } else {
            cin >> d;
            if (a == 1)
                update(b, c, 1, 1, N, 1, d);
            else if (a == 2)
                update(b, c, 1, 1, N, d, 0);
            else if (a == 3)
                update(b, c, 1, 1, N, 0, d);
        }
    }

    return 0;
}
