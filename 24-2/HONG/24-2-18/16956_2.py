R, C = map(int, input().split())

board = []

for _ in range(R):
  row = list(input())
  board.append(row)

def solve():
  
  dy = [-1, 0, 1, 0]
  dx = [0, 1, 0, -1]

  for i in range(R):
    for j in range(C):
      if board[i][j] == 'S':
        for d in range(4):
          ny, nx = i + dy[d], j + dx[d]
          if 0 <= ny < R and 0 <= nx < C:
            if board[ny][nx] == 'W':
              return 0
            elif board[ny][nx] == '.':
              board[ny][nx] = 'D'
  return 1

if solve():
  print("1")
  for row in board:
    print("".join(row))
else:
  print("0")