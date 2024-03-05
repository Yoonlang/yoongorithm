import heapq
from collections import deque
'''
1. 현재 위치에서 최단거라 - 행번호 - 열번호 순 가장 작은 승객을 고른다.
2. 승객을 목적지에 데려다주면 소모 연료양이 2배
  - 소모 연료량 체크
3. 연료 바닥남

- 무한루프 생각해야함
- 승객이 꽉차있는 경우 생각해야함
'''
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
N, M, F = map(int, input().split())

board = [[0] * (N+1)]
for _ in range(N):
  row = [0] + list(map(lambda x: int(1e10) if x == 1 else 0 ,(map(int, input().split()))))
  board.append(row)

customers = []
startY, startX = map(int, input().split())

for i in range(1, M+1):
  sy, sx, ey, ex = map(int, input().split())
  customers.append((sy,sx,ey,ex))
  board[sy][sx] = i
  board[ey][ex] = -i

visited = set()
cnt_visited = 0
def get_dist(sy, sx, ey, ex):

  distance_board = [[int(1e9)] * (N+1) for _ in range(N+1)]
  distance_board[sy][sx] = 0
  queue = deque([(sy, sx, 0)])

  while queue:
    cy, cx, cd = queue.pop()
    for d in range(4):
      ny, nx = cy + dy[d], cx + dx[d]
      if 0 < ny <= N and 0 < nx <= N and board[ny][nx] != int(1e10):
        dist = cd + 1
        if dist < distance_board[ny][nx]:
          distance_board[ny][nx] = dist
          queue.append((ny, nx, dist))

  return distance_board[ey][ex]

def init(startY, startX):
  pq = []
  for sy, sx, _, _ in customers:
    if (sy,sx) in visited: continue
    dist = get_dist(startY, startX, sy, sx)
    heapq.heappush(pq, (dist, (sy, sx)))
  dist, (ny, nx) = heapq.heappop(pq)
  visited.add((ny, nx))
  return dist, ny, nx

def move(sy, sx):
  target = board[sy][sx] - 1
  _, _, ey, ex = customers[target]
  dist = get_dist(sy, sx, ey, ex)
  return dist, ey, ex

def solve(F):
  sy, sx = startY, startX
  for _ in range(M):
    dist1, ny, nx = init(sy, sx) # start to next dest
    F -= dist1
    dist2, ey, ex = move(ny, nx) # next start to next end
    F -= dist2
    if F >= 0: F = F + dist2 * 2
    else: return -1
    sy, sx = ey, ex
  return F

print(solve(F))
