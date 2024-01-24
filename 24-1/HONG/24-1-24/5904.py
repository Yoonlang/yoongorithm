# 3, 10, 25, 56
'''
  조건 설정하기가 까다로운 문제.
  분할 정복의 핵심 : 큰 문제를 작게 나누어서, 가장 작을때 풀기!
  하노이탑 문제,
  Moo 게임 문제 등등..

  결국에 early return 하는 부분에서 많이 판가름 나는것 같다.
'''

def divide_and_conquer(n, k, b_len): # k: 차수, b_len: 이전 차수의 길이

  if n <= 3: # n 이 3이하면 바로 출력.
    print("moo"[n-1])
    return
  
  new_len = 2 * b_len + k + 3

  if n > new_len:
    divide_and_conquer(n, k+1, new_len)
  else: 
    if n <= (b_len + k + 3):
      if n == b_len + 1:
        print('m')
      else:
        print('o')
      return
    else:
      divide_and_conquer(n - (b_len + k + 3), 1, 3)

N = int(input())

divide_and_conquer(N, 1, 3)