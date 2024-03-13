from collections import deque

'''
1. 전체 돌면서, dfs로 영역 visit하기
2. 시간복잡도는 R * C 인듯.
'''

LAND = '.'
GUARD = '#'
WOLF = 'v'
SHEEP = 'k'

R, C = map(int, input().split())

board = []
for _ in range(R):
  row = list(input())
  board.append(row)

total_sheep = 0
total_wolves = 0

for i in range(R):
  for j in range(C):
    if board[i][j] == WOLF:
      total_wolves += 1
    elif board[i][j] == SHEEP:
      total_sheep += 1

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
visited = [[0 for _ in range(C)] for _ in range(R)]

def bfs(y, x):
  global count_sheep
  global count_wolves
  queue = deque([(y,x)])

  while queue:
    cy, cx = queue.pop()
    for i in range(4):
      ny, nx = cy + dy[i], cx + dx[i]
      if 0<=ny<R and 0<=nx<C and board[ny][nx] != GUARD and not visited[ny][nx]:
        visited[ny][nx] = 1
        value = board[ny][nx]
        if value == SHEEP: count_sheep += 1
        elif value == WOLF: count_wolves += 1
        queue.append((ny,nx))
  
count_sheep = 0  
count_wolves = 0

for i in range(R):
  for j in range(C):
    if not visited[i][j] and not board[i][j] != GUARD:
      visited[i][j] = 1
      if board[i][j] == WOLF: count_wolves += 1
      elif board[i][j] == SHEEP: count_sheep += 1
      bfs(i,j)
      if count_sheep > count_wolves:
        total_wolves -= count_wolves
      else:
        total_sheep -= count_sheep
      count_sheep = 0
      count_wolves = 0

print(total_sheep, total_wolves)