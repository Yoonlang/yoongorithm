from collections import deque
sero, garo = map(int, input().split())

CHEEZE = 1
AIR = 0
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(y, x):

  visited = [[0] * garo for _ in range(sero)]
  visited[y][x] = 1
  queue = deque([(y,x)])

  cnt = 0

  while queue:
    cy, cx = queue.popleft()
    for i in range(4):
      ny, nx = cy + dy[i], cx + dx[i]
      if 0 <= ny < sero and 0 <= nx < garo:
        if not visited[ny][nx] and graph[ny][nx] == AIR:
          queue.append((ny,nx))
          visited[ny][nx] = 1
        elif not visited[ny][nx] and graph[ny][nx] == CHEEZE:
          graph[ny][nx] = AIR
          visited[ny][nx] = 1
          cnt += 1

  return cnt


graph = []
for _ in range(sero):
  row = list(map(int, input().split()))
  graph.append(row)

timer = 0
cheezes = 0

while True:
  cnt = bfs(0,0)
  if cnt == 0: break
  timer += 1
  cheezes = cnt

print(timer)
print(cheezes)