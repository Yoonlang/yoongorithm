/*
2847
뒤에서부터 쭉쭉 내려주면 안되나?
*/

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int res = 0;
    int N;
    cin >> N;

    vector<int> num(N);
    for (int i = 0; i < N; i++)
        cin >> num[i];

    for (int i = N - 2; i >= 0; i--) {
        if (num[i] >= num[i + 1]) {
            res += num[i] - num[i + 1] + 1;
            num[i] = num[i + 1] - 1;
        }
    }

    cout << res;

    return 0;
}
