def get_dist(a,b):
  return abs(a[0]-b[0]) + abs(a[1]-b[1])

N, HP, UP = map(int, input().split()) # 10 이하

LAND = 0
HOME = 1
MILK = 2

global answer
answer = 0

graph = []
for _ in range(N):
  row = list(map(int, input().split()))
  graph.append(row)

milks = []
for i in range(N):
  for j in range(N):
    if graph[i][j] == HOME:
      home = (i,j)
    elif graph[i][j] == MILK:
      milks.append((i,j))

def go(current, visited, hp, cnt):
  global answer
  if hp >= get_dist(home, current): answer
  for milk in milks:
    if milk in visited:
      continue
    dist = get_dist(current, milk)
    if hp - dist >= 0:
      visited.add(milk)
      go(milk, set(visited), hp - dist + UP, cnt+1)
      visited.discard(milk)

## 돌아올 수 있어야 HP를 업데이트해야한다.

visited = set()
visited.add(home)
go(home, visited, HP, 0)

print(answer)