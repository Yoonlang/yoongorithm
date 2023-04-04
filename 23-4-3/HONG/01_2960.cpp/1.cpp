#include <algorithm>
#include <iostream>
using namespace std;

int che[1001];

int main(void) {

    int N, K, cnt = 0;
    cin >> N >> K;

    for (int i = 2; i <= N; i++) {
        for (int j = 1; j * i <= N; j++) {
            if (che[j * i] == 0) {
                cnt += 1;
                che[j * i] = 1;
                if (cnt == K) {
                    cout << j * i;
                    return 0;
                }
            }
        }
    }

    return 0;
}
