#include <bits/stdc++.h>

using namespace std;

bool isPrime(long long n) {
    if (n == 0 || n == 1)
        return false;
    if (n == 2 || n == 3)
        return true;
    for (long long i = 2; i <= ceil(sqrt(n)); i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

int main(void) {

    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        long long point;
        cin >> point;
        long long j = point;
        while (!isPrime(j))
            j++;
        cout << j << "\n";
    }
    return 0;
}