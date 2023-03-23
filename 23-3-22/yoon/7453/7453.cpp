#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    unordered_map<int, int> AB;
    int N, a, b, c, d;
    cin >> N;
    vector<int> A(N), B(N), C(N), D(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i] >> B[i] >> C[i] >> D[i];
    }

    for (auto a : A) {
        for (auto b : B) {
            AB[a + b]++;
        }
    }

    long long res = 0;
    for (auto c : C) {
        for (auto d : D) {
            int sum = -1 * (c + d);
            if (AB.find(sum) != AB.end()) {
                res += AB[sum];
            }
        }
    }

    cout << res;

    return 0;
}
