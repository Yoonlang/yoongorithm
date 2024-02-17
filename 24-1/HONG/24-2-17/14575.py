N, T = map(int, input().split())

arr = []

low = 1
high = 1

for _ in range(N):
  l, r = map(int, input().split())
  low = max(low, l)
  high = max(high, r)
  arr.append((l,r))

def solve():

  global low
  global high

  if sum(map(lambda x: x[1], arr)) < T: return -1
  if sum(map(lambda x: x[0], arr)) > T: return -1
    
  while low+1 < high:
    mid = (low + high) // 2
    max_sum = sum(map(lambda x: x[1] if x[1] <= high else high, arr))
    if T > max_sum:
      low = mid
    else:
      high = mid
  
  while True:
    max_sum = sum(map(lambda x: x[1] if x[1] <= low else low, arr))
    if T <= max_sum:
      return low
    low += 1
    
print(solve())

