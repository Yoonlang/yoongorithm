#include <bits/stdc++.h>

using namespace std;

set<int> numbers;

int N, K;
// K: [1, N)
// N: (max(1, K), 1000]

int main(void) {
    cin >> N >> K;

    for (int i = 2; i <= N; i++) {
        numbers.insert(i);
    }

    int startingFrom = 2;
    int counter = 0;

    int pointer = startingFrom;
    while (!numbers.empty()) {
        if (numbers.find(pointer) != numbers.end()) {
            numbers.erase(pointer);
            counter++;
        }

        if (counter == K) {
            cout << pointer;
            return 0;
        }

        pointer += startingFrom;

        if (pointer > N) {
            startingFrom = *(numbers.begin());
            pointer = startingFrom;
        }
    }

    return 0;
}