from collections import deque

sero, garo = map(int, input().split())

board = []
wolves = []

for i in range(sero):
  row = list(input())
  board.append(row)
  for j, type in enumerate(row):
    if type == 'W':
      wolves.append((i, j))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for y, x in wolves:
  for d in range(4):
    ny, nx = y + dy[d], x + dx[d]
    if 0 <= ny < sero and 0 <= nx < garo:
      if board[ny][nx] == '.':
        board[ny][nx] = 'D'

def solve():

  visited = [[0 for _ in range(garo)] for _ in range(sero)]

  def bfs(start):

    visited[start[0]][start[1]] = 1
    queue = deque([start])

    while queue:
      cy, cx = queue.popleft()
      for i in range(4):
        ny, nx = cy + dy[i], cx + dx[i]
        if 0 <= ny < sero and 0 <= nx < garo:
          if visited[ny][nx]: continue
          if board[ny][nx] in ['W', '.']:
            queue.append((ny, nx))
            visited[ny][nx] = 1
          elif board[ny][nx] == 'S':
            return 0
    return 1

  for y, x in wolves:
    if not bfs((y,x)):
      return 0
  return 1

if solve():
  print("1")
  for row in board:
    print("".join(row))
else:
  print("0")