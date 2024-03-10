LAND = 0
HOME = 1
MILK = 2

N, M, H = map(int, input().split())

def get_dist(a, b):
  return abs(a[0]-b[0]) + abs(a[1]-b[1])

board = []
for _ in range(N):
  row = list(map(int, input().split()))
  board.append(row)

milks = []
for i in range(N):
  for j in range(N):
    if board[i][j] == HOME:
      home = (i,j)
    elif board[i][j] == MILK:
      milks.append((i,j))

answer = 0
visited = set()
def dfs(current, hp):
  global answer
  global visited

  if hp >= get_dist(current, home): # early return 하면 안되는 경우가 있음
    answer = max(answer, len(visited))

  for milk in milks: # 미리 방문할곳을 저장해놓는 유형
    dist = get_dist(current, milk)
    if hp >= dist and milk not in visited:
      visited.add(milk) # 방문했음, 안했음을 저장하는것 항상 유의.
      dfs(milk, hp-dist+H)
      visited.discard(milk) # discard vs remove 차이있음.

dfs(home, M)

print(answer)