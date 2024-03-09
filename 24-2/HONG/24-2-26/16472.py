abc = dict()
for i in range(26):
  abc.setdefault(chr(97+i), i)

answer = 0
N = int(input())

arr = list(map(lambda x: abc[x], input()))

left = 0
len_arr = len(arr)
while left < len_arr-1:
  check = [0] * 26
  check[arr[left]] = 1
  long_count = 1
  another_count = 1

  right = left + 1
  while right < len_arr:
    if check[arr[right]] == 0:
      check[arr[right]] = 1
      another_count += 1
      if another_count > N: break
    long_count += 1
    right += 1
  answer = max(answer, long_count)
  
  while left < len_arr-1 and arr[left] == arr[left+1]:
    left += 1
  if left < len_arr-1 and arr[left] != arr[left+1]:
    left += 1

print(answer)
