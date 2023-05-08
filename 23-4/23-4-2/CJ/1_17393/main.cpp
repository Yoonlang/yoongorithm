#include <bits/stdc++.h>

using namespace std;

/**
 * 현재 위치보다 오른쪽에 있으면서도
 * 점도지수가 서 있는 칸의 잉크 지수 (A_i) 이하인 칸을
 * 칠할 수 있다
 *
 * 각 칸의 잉크 지수 A_i는 점도지수 B_i 이상
 * 점도 지수 B_i는 항상 오름차순 => binary search
 *
 * 롤러로 칠할 수 있는 최대의 칸 수
 */

int N;
vector<long long> inks;
vector<long long> stickinesses;

int main(void) {
    cin >> N;

    for (int i = 0; i < N; i++) {
        long long ink;
        cin >> ink;
        inks.push_back(ink);
    }
    for (int i = 0; i < N; i++) {
        long long stickiness;
        cin >> stickiness;
        stickinesses.push_back(stickiness);
    }

    for (int i = 0; i < N; i++) {
        int standing_index = i;
        long long standing_ink = inks[standing_index];

        long long upper_matching_index =
            upper_bound(stickinesses.begin(), stickinesses.end(),
                        standing_ink) -
            stickinesses.begin();

        long long diff = upper_matching_index - standing_index - 1;
        if (diff <= 0) {
            cout << "0 ";
        } else {
            cout << diff << " ";
        }
    }

    return 0;
}