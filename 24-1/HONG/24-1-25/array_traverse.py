arr = [1,2,3,4,5]

for item in reversed(arr):
  print(item)

for i in range(len(arr)-1, -1, -1):
  print(arr[i])

for item in arr[::-1]:
  print(item)

aaa = "abcdefghijklmnopq"
print("".join(list(reversed(aaa))))

dict = {
  'a': 1,
  'b': 2,
  'c': 3,
}

print("-".join(map(str, dict.items())))