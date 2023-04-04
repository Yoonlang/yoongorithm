#include <bits/stdc++.h>

using namespace std;

long long N;  // [1, 1000]
int set_size; // [0, 50]
vector<int> available;
vector<int> excludes;

// find three numbers that is closest to N
// However, exclude the numbers in excludes

// I think I should do binary search => that went badly

// I think I gotta consider that N is lower than 1_000

int main(void) {
    cin >> N >> set_size;

    if (set_size == 0) {
        cout << "0\n";
        return 0;
    }

    for (int i = 0; i < set_size; i++) {
        int exclude;
        cin >> exclude;
        excludes.push_back(exclude);
    }
    sort(excludes.begin(), excludes.end());

    int idx = 0;
    for (int i = 1; i <= 1002; i++) {
        if (idx < excludes.size() && excludes[idx] == i) {
            idx++;
            continue;
        }
        available.push_back(i);
    }

    long long lowest = INT_MAX;
    for (int i = 0; i < available.size(); i++) {
        for (int j = i; j < available.size(); j++) {
            for (int k = j; k < available.size(); k++) {
                long long product = available[i] * available[j] * available[k];
                lowest = min(lowest, abs(N - product));
            }
        }
    }

    cout << lowest << "\n";

    return 0;
}