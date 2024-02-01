N, K = map(int, input().split())
arr = list(map(int, input().split()))
arr.insert(0,0)
for i in range(1, N+1):
  arr[i] += arr[i-1]

answer = -int(1e11)

for i in range(1, N+1-K+1):
  left = i
  right = left + (K - 1)

  sum = arr[right] - arr[left-1]

  answer = max(sum, answer)

print(answer)


  


