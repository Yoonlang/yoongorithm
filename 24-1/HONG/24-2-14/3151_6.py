'''
너무 쉽게 생각했다.
이건 따지고보면,, 
N * N * logN * N 에서, 마지막 N 이 굉장히 작다고 생각했지만, 히든케이스가 있었다.
N * N * logN * logN 즉, logN을 활용해야한다.
'''
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
        else: # find == arr[mid]
          thigh, tlow = mid - 1, mid + 1
          # find left_bound
          while low <= thigh:
            tmid = (low + thigh) // 2
            if find > arr[tmid]:
              low = tmid + 1
            elif find == arr[tmid]:
              thigh = tmid - 1
          # find right_bound
          while tlow <= high:
            tmid = (tlow + high) // 2
            if find < arr[tmid]:
              high = tmid - 1
            elif find == arr[tmid]:
              tlow = tmid + 1
          ans += (high - low + 1)
          break
      j += 1
  return ans

ans = solve()

print(ans)