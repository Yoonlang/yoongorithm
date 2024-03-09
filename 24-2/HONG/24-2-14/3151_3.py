N = int(input())
arr = list(map(int, input().split()))

ans = 0 

def combinations(n, c):
  combs = []
  def combine(comb, start):
    if len(comb) == c:
      combs.append(comb[:])
      return
    
    for i in range(start, n):
      comb.append(i)
      combine(comb, i+1)
      comb.pop()
  
  combine([], 0)
  return combs

combs = combinations(N, 3)

for comb in combs:
  if sum([arr[comb[0]], arr[comb[1]], arr[comb[2]]]) == 0:
    ans += 1

print(ans)
  