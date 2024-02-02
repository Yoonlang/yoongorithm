N, M =  map(int, input().split())

lines = set()

for _ in range(N):
  line = input()
  lines.add(line)

ans = 0
for _ in range(M):
  line = input()
  if line in lines:
    ans += 1

print(ans)