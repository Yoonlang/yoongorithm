#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, res = 0, i = 0, j = 0, sum = 0;
    cin >> N >> M;
    vector<int> list(N);
    for (int i = 0; i < N; i++)
        cin >> list[i];

    while (i < N && j < N) {
        if (sum == M) {
            res++;
            sum -= list[i];
            i++;
        } else if (sum > M) {
            sum -= list[i];
            i++;

        } else {
            sum += list[j];
            j++;
        }
    }
    for (; i < N; i++) {
        if (sum == M)
            res++;
        if (sum < M)
            break;
        sum -= list[i];
    }

    cout << res;

    return 0;
}
