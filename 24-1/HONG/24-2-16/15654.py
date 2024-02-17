N, M  = map(int, input().split())
arr = sorted(list(map(int, input().split())))

# 순열
def permutations(n, p):
  perms = []
  picked = [0] * (n)
  def permutate(perm):
    if len(perm) == p:
      perms.append(perm)
      return
    for i in range(0, n):
      if picked[i]: continue
      perm.append(i)
      picked[i] = 1
      permutate(perm[:])
      perm.pop()
      picked[i] = 0
  permutate([])
  return perms

for perm in permutations(N, M):
  for idx in perm:
    print(arr[idx], end=" ")
  print("")