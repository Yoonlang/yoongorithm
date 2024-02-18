N = int(input())

items = [0] * N

for i in range(N):
  items[i] = int(input())

total = sum(items)

answer = 0

def solve():

  # 미리 안되는 경우 리턴
  _max = max(items)
  _min = min(items)
  if _max - _min > 1: return 0
  
  counts = [0, 0, 0, 0, 0]
  def dfs(marbles):
    global answer

    if len(marbles) == total:
      answer += 1
      return

    for i in range(N):
      if len(marbles) >= 1 and marbles[-1] == i: continue
      if len(marbles) >= 2 and marbles[-2] == i: continue
      if counts[i] >= items[i]: continue
      counts[i] += 1
      marbles.append(i)
      dfs(marbles)
      counts[i] -= 1
      marbles.pop()
  
  for i in range(N):
    counts[i] += 1
    dfs([i])
    counts[i] -= 1

solve()

print(answer)