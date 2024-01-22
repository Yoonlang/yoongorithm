x = int(input())

arr = [1,2,3,4,5,6,7,8,9,10]

left = 0
right = len(arr)

while True:
  mid = (left + right) // 2
  if arr[mid] < x:
    left = mid
  elif arr[mid] > x:
    right = mid
  else:
    print("index:", mid)
    break