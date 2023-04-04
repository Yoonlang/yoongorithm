#include <bits/stdc++.h>

using namespace std;

/**
 * light all the N roads
 *
 * all street lights should be same height
 *
 * If the height of street light is H, it lights to left by H, to right by H
 *
 */

int road_length; // [1, 100_000]
int lights;      // [1, N(100_000)]

void print_debug(int n) { cout << n << "\n"; }

int main(void) {
    cin >> road_length >> lights;

    int well_lit = 0;
    int max_height = 0;

    int spot;
    int prev_spot = 0;

    cin >> spot;
    max_height = spot;
    well_lit = spot + max_height;
    prev_spot = spot;

    for (int i = 1; i < lights; i++) {
        cin >> spot;
        int distance_to_light = spot - well_lit;
        int cannot_reach = distance_to_light > max_height;

        if (cannot_reach) {
            max_height = ceil((spot - prev_spot + 1) / 2);
        }

        well_lit = spot + max_height;
        prev_spot = spot;
    }

    max_height = max(max_height, road_length - spot);

    cout << max_height;
    return 0;
}