N, M = map(int, input().split())
heights = list(map(int, input().split())) # map, filter, iterables(string, tuple, range, 딕셔너리, 세트)는 list 로 변환가능.

ans = 0
left = 0
right = max(heights)

while left <= right:
  mid = (left + right)//2
  
  # get tree heights
  tree = 0
  for height in heights:
    if height > mid:
      tree += (height - mid)
  
  # if..
  if tree == M:
    ans = mid
    break
  elif tree < M: 
    right = mid - 1
  else: 
    left = mid + 1

# left는 mid+1로 설정하기 때문에, 마지막 쯤에 만족하지 않을 수 있음.
# right는 mid-1 로 설정하기 때문에, 항상 만족하기 마련임. 
if left > right:
  print(right)
else:
  print(ans)