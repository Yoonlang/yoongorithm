'''
1. 모델링
2. nC0, nC1, nC2, nC3 체크
3. 시뮬레이션
'''

N, M, H = map(int, input().split())
h = [[] for _ in range(H+1)]

# 0. 세팅
moves = list()
for row in range(1,H+1):
  for col in range(1,N):
    moves.append((row, col))


# 1. 모델링
for _ in range(M):
  a, b = map(int, input().split())
  h[a].append(b)
  moves.remove((a,b))

# 1-2. i번에서 i번인지 체크함수
def is_cameback(h, i):
  current = i
  for level in range(1, H+1):
    for move in h[level]:
      if move == current-1: # left
        current = current-1
      elif move == current: # right
        current = current+1
  return current == i

def is_validate(h):
  for i in range(1, N+1):
    if not is_cameback(h, i):
      return 0
  return 1

# 1-3. 인접한게 있는지 체크
def is_adjecent(h):
  for level in range(1, H+1):
    for i in range(0, len(h[level]) -1):
      if abs(h[level][i+1] - h[level][i]) == 1:
        return 1
  return 0

# 2. 조합 체크
def solve():
  # nC0 : 아무것도 없을때 체크
  h1 = [row[:] for row in h]
  if is_validate(h1):
    return 0
  
  # nC1 : 하나 해봤을 때 체크
  for move in moves:
    h2 = [row[:] for row in h]
    h2[move[0]].append(move[1])
    if is_adjecent(h2):
      continue
    if is_validate(h2):
      return 1
  
  # nC2 : 두개 했을때 체크
  length = len(moves)
  for i in range(0, length-1):
    for j in range(i+1, length):
      h3 = [row[:] for row in h]
      h3[moves[i][0]].append(moves[i][1])
      h3[moves[j][0]].append(moves[j][1])
      if is_adjecent(h3):
        continue
      if is_validate(h3):
        return 2
  
  # nC3 : 세개 했을때 체크
  for i in range(0, length-2):
    for j in range(i+1, length-1):
      for k in range(j+1, length):
        h4 = [row[:] for row in h]
        h4[moves[i][0]].append(moves[i][1])
        h4[moves[j][0]].append(moves[j][1])
        h4[moves[k][0]].append(moves[k][1])
        if is_adjecent(h4):
          continue
        if is_validate(h4):
          return 3

  return -1

print(solve())