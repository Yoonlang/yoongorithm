T = int(input())

for t in range(T):
  line = input()
  abc = [0] * 26

  for ch in line:
    if ch == ' ':
      continue
    order = ord(ch) - ord('a')
    abc[order] += 1
  
  max_i = 0
  for i in range(1, 26):
    if abc[i] > abc[max_i]:
      max_i = i
  
  same_cnt = 0
  for i in range(26):
    if abc[max_i] == abc[i]:
      same_cnt += 1
  
  if same_cnt == 1:
    print(chr(max_i + ord('a')))
  else:
    print('?')