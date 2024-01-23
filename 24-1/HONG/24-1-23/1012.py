import sys
sys.setrecursionlimit(10**5)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def dfs(y, x):
  visited[y][x] = 1

  for i in range(4):
    ny, nx = y + dy[i], x + dx[i]
    if 0 <= nx < garo and 0 <= ny < sero and cabbage_map[ny][nx] and not visited[ny][nx]:
      dfs(ny, nx)

T = int(input())

for t in range(T):
  garo, sero, K = map(int, input().split())
  answer = 0
  cabbage_map = [[0] * garo for _ in range(sero)]
  visited = [[0] * garo for _ in range(sero)]
  for k in range(K):
    x, y = map(int, input().split())
    cabbage_map[y][x] = 1

  for i in range(0, sero):
    for j in range(0, garo):
      if visited[i][j] == 0 and cabbage_map[i][j] == 1:
        dfs(i, j)
        answer += 1

  print(answer)