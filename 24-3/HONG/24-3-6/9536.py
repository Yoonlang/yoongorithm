T = int(input())

for t in range(T):
  words_arr = list(map(lambda x: (x,0), input().split()))
  while 1:
    say = input()
    if say.strip() == 'what does the fox say?':
      for word, flag in words_arr:
        if flag == 0: print(word, end=" ")
      break
    else:
      animal, goes, sound = say.split()
      words_arr = list(map(lambda x: (x[0],1) if x[0] == sound else x, words_arr))
  print("")