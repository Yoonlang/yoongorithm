EAST = 1
WEST = 2
NORTH = 3
SOUTH = 4

dy, dx = [0, 0, 0, -1, 1], [0, 1, -1, 0, 0]
sero, garo, y, x, K = map(int, input().split())

board = []
dice = [0, 0, 0, 0, 0, 0, 0]

def check():
    if board[y][x] == 0:
        board[y][x] = dice[6]
    else:
        dice[6] = board[y][x]
    print(dice[1])

def move_east():
    tmp = dice[1]
    dice[1] = dice[4]
    dice[4] = dice[6]
    dice[6] = dice[3]
    dice[3] = tmp

def move_west():
    tmp = dice[3]
    dice[3] = dice[6]
    dice[6] = dice[4]
    dice[4] = dice[1]
    dice[1] = tmp

def move_north():
    tmp = dice[2]
    dice[2] = dice[1]
    dice[1] = dice[5]
    dice[5] = dice[6]
    dice[6] = tmp

def move_south():
    tmp = dice[6]
    dice[6] = dice[5]
    dice[5] = dice[1]
    dice[1] = dice[2]
    dice[2] = tmp

for _ in range(sero):
    row = list(map(int, input().split()))
    board.append(row)

orders = list(map(int, input().split()))

for order in orders:
    ny = y + dy[order]
    nx = x + dx[order]
    if not ((0 <= nx < garo) and (0 <= ny < sero)):
        continue
    y = ny
    x = nx

    if order == EAST:
        move_east()
    elif order == WEST:
        move_west()
    elif order == NORTH:
        move_north()
    elif order == SOUTH:
        move_south()
    check()
