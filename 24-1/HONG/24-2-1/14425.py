N, M =  map(int, input().split())

# O(N * M * len)

lines = []

for _ in range(N):
  line = input()
  lines.append(line)

cnt = 0
for _ in range(M):
  compare = input()
  good = 0

  for line in lines:
    if len(line) != len(compare):
      continue

    skip = 0
    for i in range(len(line)):
      if line[i] != compare[i]:
        skip = 1
        break
    
    if skip:
      continue

    good = 1
    break

  cnt += good

print(cnt)