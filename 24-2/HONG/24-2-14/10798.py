lines = []
for _ in range(5):
  line = list(input())
  lines.append(line)

for i in range(15):
  for j in range(5):
    try: 
      print(lines[j][i], end="")
    except:
      pass