N, T = map(int, input().split())

arr = list(map(int, input().split())) # 5 4 3 2 1
for i in range(1, N): # 5 9 12 14 15
  arr[i] += arr[i-1]
arr.insert(0, 0)

for t in range(T):
  s, e = map(int, input().split())
  print(arr[e] - arr[s-1])