#include <iostream>
#include <string>
#include <vector>

using namespace std;

void process(vector<string> &v, int N, int left, int right, int depth) {
    if (depth >= 7)
        return;
    if (left > right)
        return;
    int mid = (left + right) / 2;

    for (int i = left; i <= mid; i++) {
        v[depth][i] = 'A';
    }
    for (int i = mid + 1; i <= right; i++) {
        v[depth][i] = 'B';
    }

    process(v, N, left, mid, depth + 1);
    process(v, N, mid + 1, right, depth + 1);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<string> v(7, string(N, '.'));
    process(v, N, 0, N - 1, 0);

    for (auto i : v) {
        if (i.find("B") == string::npos) {
            i[0] = 'B';
        }
        cout << i << endl;
    }

    return 0;
}
