N = int(input())
arr = list(map(lambda x: ord(x) - ord('a'), input()))

answer = 0

left = 0
right = 0
counts = dict()

while right < len(arr):
  if counts.get(arr[right], -1) == -1: # 만약 없으면
    counts.setdefault(arr[right], 0)
  counts[arr[right]] += 1
  if len(counts) > N:
    while left < right:
      counts[arr[left]] -= 1
      if counts[arr[left]] == 0:
        del counts[arr[left]]
        left += 1
        break
      left += 1
  right += 1
  answer = max(answer, right-left)

print(answer)
