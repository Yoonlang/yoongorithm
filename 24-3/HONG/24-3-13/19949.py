answers = list(map(int, input().split()))

N = 10
pick = [0] * 11
answer = 0

def dfs(current, cnt):
  global answer
  if current == 10:
    if cnt >= 5:
      answer += 1
    return

  for i in range(1,5+1):
    if current-2 >= 0 and pick[current-2] == pick[current-1] and pick[current-1] == i: continue

    pick[current] = i
    if answers[current] == i:
      dfs(current+1, cnt+1)
    else:
      dfs(current+1, cnt)

dfs(0, 0)

print(answer)
    