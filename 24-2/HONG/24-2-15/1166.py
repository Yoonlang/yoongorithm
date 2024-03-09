N, A, B, C = map(int, input().split())

arr = sorted([A, B, C])

low = 0
high = min(arr)

cnt = 0
bef = 0

while low <= high:
  mid = (low + high) / 2
  if abs(mid - bef) <= 0.00000000000000001: break
  a = arr[0] // mid
  b = arr[1] // mid
  c = arr[2] // mid
  items = a * b * c

  if items >= N:
    low = mid
  elif items < N:
    high = mid
  bef = mid

print("%.15f"%mid)