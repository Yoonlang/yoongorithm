a = list(map(int, input().split(':')))
b = list(map(int, input().split(':')))

def get_seconds(time):
  h = time[0]
  m = time[1]
  s = time[2]
  tot = h * 3600 + m * 60 + s
  return tot

def format_seconds(time):
  h = time // 3600
  time %= 3600
  m = time // 60
  time %= 60
  s = time
  return fixed_format(h) + ":" + fixed_format(m) + ":" + fixed_format(s)

def fixed_format(num):
  if num > 9:
    return str(num)
  else:
    return "0" + str(num)


a_seconds = get_seconds(a)
b_seconds = get_seconds(b)
b_seconds_added = get_seconds([b[0] + 24, b[1], b[2]])

if b_seconds - a_seconds > 0:
  print(format_seconds(b_seconds - a_seconds))
else:
  print(format_seconds(b_seconds_added - a_seconds))

