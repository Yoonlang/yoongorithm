N = int(input())

words = set()

for _ in range(N):
  word = input()
  words.add(word)

print("\n".join(sorted(words, key=lambda x: (len(x), x))))