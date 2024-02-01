N, M = map(int, input().split())
arr = list(map(int, input().split()))
for i in range(1, N):
  arr[i] += arr[i-1]
arr.insert(0,0)

cnt = 0
left, right = 1, 1
while True :

  if right > N or left > N:
    break

  sum = arr[right] - arr[left-1] # [left, right] 사이의 합

  if sum == M:
    cnt += 1
    right += 1
  elif sum < M:
    right += 1
  else:
    left += 1

print(cnt)