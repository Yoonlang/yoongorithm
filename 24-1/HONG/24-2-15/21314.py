def convert(words):
  result = ""
  for word in words:
    if word[-1] == 'K':
      result += "5" + "0" * (len(word)-1)
    elif word[-1] == 'M':
      result += "1" + "0" * (len(word)-1)
  return result

def get_largest(words):
  largest = []
  for word in words:
    if word[-1] == "M":
      for _ in range(len(word)):
        largest.append("M")
    else:
      largest.append(word)
  return largest

def get_smallest(words):
  smallest = []
  for word in words:
    if len(word) >=2 and word[-1] == 'K':
      smallest.append(word[:-1])
      smallest.append("K")
    else:
      smallest.append(word)
  return smallest

line = input()

line = line.replace('K', 'K_')

words = line.split('_')

if words[-1] == '':
  words.pop()

largest = get_largest(words)

smallest = get_smallest(words)

print(convert(largest))
print(convert(smallest))
