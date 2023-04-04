#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_set<int> s;

    int N, M, a, res = 0;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> a;
        if (s.find(M - a) != s.end())
            res++;
        s.insert(a);
    }
    cout << res;

    return 0;
}
