N = int(input())
arr = list(map(int, input().split()))

ans = 0 

for i in range(0, N-2):
  for j in range(i+1, N-1):
    for k in range(j+1, N-0):
      sum = arr[i] + arr[j] + arr[k]
      if sum == 0:
        ans += 1

print(ans)