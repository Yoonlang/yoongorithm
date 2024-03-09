N, L = map(int, input().split())
arr = sorted(list(map(int, input().split())))

for e in arr:
  if e <= L:
    L += 1
  else:
    break

print(L)