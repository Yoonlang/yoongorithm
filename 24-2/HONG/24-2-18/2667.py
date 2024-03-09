from collections import deque
N = int(input())

board = []
for _ in range(N):
  row = list(input())
  board.append(row)

visited = [[0 for _ in range(N)] for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(start):


  queue = deque([start])
  visited[start[0]][start[1]] = 1
  cnt = 1

  while queue:
    cy, cx = queue.popleft()

    for i in range(4):
      ny, nx = cy + dy[i], cx + dx[i]
      if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx]: 
        if board[ny][nx] == '1':
          queue.append((ny, nx))
          visited[ny][nx] = 1
          cnt += 1

  return cnt

danzis = []

for i in range(N):
  for j in range(N):
    if visited[i][j] or board[i][j] == '0': continue
    danzis.append(bfs((i,j)))

print(len(danzis))
print(*sorted(danzis), sep="\n")
