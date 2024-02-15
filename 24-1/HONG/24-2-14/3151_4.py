N = int(input())
arr = list(map(int, input().split()))

def solve():
  arr.sort()
  ans = 0
  for i in range(N-2):
    j = i + 1
    while j < N-1:
      find = -(arr[i] + arr[j])
      low = j + 1
      high = N - 1
      while low <= high:
        mid = (low + high) // 2
        if find < arr[mid]:
          high = mid - 1
        elif find > arr[mid]:
          low = mid + 1
        else:
          ans += 1
          left, right = mid - 1, mid + 1
          while low <= left and arr[left] == find:
            ans += 1
            left -= 1
          while right <= high and arr[right] == find:
            ans += 1
            right += 1
          break
      j += 1
  return ans

ans = solve()

print(ans)