#include <algorithm>
#include <cmath>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int, int> ti;

int sqrtN;

bool compare(const ti &a, const ti &b) {
    if (get<1>(a) / sqrtN != get<1>(b) / sqrtN)
        return get<1>(a) < get<1>(b);
    return get<2>(a) < get<2>(b);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b;
    cin >> N;
    vector<int> nums(N + 1);
    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    cin >> M;
    vector<ti> querys(M);
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        querys[i] = {i, a, b};
    }

    sqrtN = sqrt(N);
    sort(querys.begin(), querys.end(), compare);

    int result = 0;
    vector<int> res(M);
    vector<int> value(1000001);

    int s = get<1>(querys[0]), e = get<2>(querys[0]);
    for (int i = s; i <= e; i++) {
        if (value[nums[i]] == 0)
            result++;
        value[nums[i]]++;
    }
    res[get<0>(querys[0])] = result;

    for (auto &query : querys) {
        int idx = &query - &querys[0];
        if (idx == 0)
            continue;

        int ss = get<1>(query), ee = get<2>(query);
        while (s < ss) {
            value[nums[s]]--;
            if (value[nums[s]] == 0)
                result--;
            s++;
        }
        while (s > ss) {
            if (value[nums[s - 1]] == 0)
                result++;
            value[nums[s - 1]]++;
            s--;
        }
        while (e < ee) {
            if (value[nums[e + 1]] == 0)
                result++;
            value[nums[e + 1]]++;
            e++;
        }
        while (e > ee) {
            value[nums[e]]--;
            if (value[nums[e]] == 0)
                result--;
            e--;
        }
        res[get<0>(query)] = result;
    }

    for (auto i : res) {
        cout << i << '\n';
    }
    return 0;
}
