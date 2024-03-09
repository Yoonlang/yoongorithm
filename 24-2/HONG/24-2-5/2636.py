from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
AIR = 0
CHEEZE = 1
SAFE_AIR = 2

def cnt_cheeze():
  cnt = 0
  for i in range(sero):
    for j in range(garo):
      if graph[i][j] == CHEEZE:
        cnt += 1
  return cnt

def make_polluted():
  visited = [[0] * garo for _ in range(sero)] 
  def pollute_bfs(i, j):
    queue = deque([(i, j)])
    while queue:
      cy, cx = queue.popleft()
      for d in range(4):
        nx, ny = dx[d]+cx, dy[d]+cy
        if nx < 0 or ny < 0 or nx >= garo or ny >= sero or visited[ny][nx]:
          continue
        if graph[ny][nx] == SAFE_AIR or graph[ny][nx] == AIR:
          graph[ny][nx] = AIR
          queue.append((ny, nx))
          visited[ny][nx] = True

  for i in range(sero):
    for j in range(garo):
      if graph[i][j] == SAFE_AIR:
        for d in range(4):
          ny, nx = dy[d] + i, dx[d] + j
          if ny < 0 or nx < 0 or ny >= sero or nx >= garo:
            graph[i][j] = AIR
            break
      if graph[i][j] == AIR:
        pollute_bfs(i, j)

def will_be_melted(i, j):
  for d in range(4):
    ny, nx = i + dy[d], j + dx[d]
    if ny < 0 or nx < 0 or ny >= sero or nx >= garo or graph[ny][nx] == AIR:
      return True
  return False
  
def melting_cheeze(graph):
  # cheeze가 air에 닿거나 & 경계에 있으면 녹는다..
  tmp_graph = [row[:] for row in graph]
  for i in range(sero):
    for j in range(garo):
      if graph[i][j] == CHEEZE and will_be_melted(i, j):
        tmp_graph[i][j] = AIR # 여기서 바로 녹여버리면,, 안되지!

  return tmp_graph

sero, garo = map(int, input().split())

graph = [] # 0: air, 1: cheeze, 2: safe_air

for i in range(sero):
  row = list(map(int, input().split()))
  row = list(map(lambda x: SAFE_AIR if x == AIR else x, row))
  graph.append(row)

answer = 0
previous_cheeze = cnt_cheeze()

while True:
  make_polluted()
  graph = melting_cheeze(graph)
  answer += 1
  tmp = cnt_cheeze()
  if tmp == 0:
    break
  previous_cheeze = tmp

print(answer)
print(previous_cheeze)