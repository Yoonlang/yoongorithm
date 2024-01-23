# 짝수만 담은 배열 만들기
even_numbers = [ num for num in range(10) if num % 2 == 0 ]
print(even_numbers)

# 1단계 flatten 하기
matrix = [[1, 2, [3, 3, 3]], [4, 5, 6], [7, 8, 9]]
flattend_matrix = [ num for rows in matrix for num in rows ]
print(flattend_matrix)

# 제곱한 배열 만들기
squared_arr = [x**2 for x in range(1, 6)]
print(squared_arr)