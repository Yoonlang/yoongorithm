T = int(input())

for t in range(T):
  line = input().replace(' ', '')
  abc = [0] * 26

  for ch in line:
    abc[ord(ch) - ord('a')] += 1
  
  cnt = abc.count(max(abc))

  if cnt > 1:
    print('?')
  else:
    print(chr(abc.index(max(abc)) + ord('a')))