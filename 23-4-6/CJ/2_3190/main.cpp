#include <bits/stdc++.h>
using namespace std;
#define X second
#define Y first

int board_size; // [2, 100]
int apple;      // [0, 100]
int apples[101][101];
int change; // [1, 100]
int board[101][101];
pair<int, int> head = {1, 1};
queue<pair<int, int>> snake;
int dir_idx = 0;
int dir[][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
queue<pair<int, char>> changes;

bool isHeadOK() {
    if (board[head.Y][head.X])
        return false;

    if (head.Y <= 0 || head.Y > board_size || head.X <= 0 ||
        head.X > board_size)
        return false;

    return true;
}

void printBoard() {
    cout << time << " " << head.Y << " " << head.X << " "
         << "\n";
    for (int i = 1; i <= board_size; i++) {
        for (int j = 1; j <= board_size; j++) {
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
    cout << "\n";
}

int main(void) {
    cin >> board_size >> apple;
    for (int i = 0; i < apple; i++) {
        int y, x;
        cin >> y >> x;
        apples[y][x] = 1;
    }
    cin >> change;
    for (int i = 0; i < change; i++) {
        int time;
        char dir;
        cin >> time >> dir;
        changes.push({time, dir});
    }

    int time = 0;
    snake.push(head);
    board[head.Y][head.X] = 1;
    while (1) {
        if (!changes.empty() && changes.front().first == time) {
            char direction = changes.front().second;
            changes.pop();

            if (direction == 'D') {
                dir_idx = (dir_idx + 5) % 4;
            } else {
                dir_idx = (dir_idx + 3) % 4;
            }
        }
        head.Y += dir[dir_idx][0];
        head.X += dir[dir_idx][1];
        time++;

        if (!isHeadOK())
            break;

        board[head.Y][head.X] = 1;
        snake.push(head);
        if (!apples[head.Y][head.X]) {
            board[snake.front().Y][snake.front().X] = 0;
            snake.pop();
        }
        apples[head.Y][head.X] = 0;
    }
    cout << time << "\n";

    return 0;
}