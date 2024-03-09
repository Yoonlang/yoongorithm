_list = [1,2,3,4,5]

print(*_list) # list, set, tuple 가능.

num_list = [1, 2, 3, 4, 5]

num_iterator = iter(num_list)

print(num_iterator)

print(next(num_iterator))
print(next(num_iterator))
print(next(num_iterator))
print(next(num_iterator))
print(next(num_iterator))
print(next(num_iterator))


'''
1. list 에서 in 사용하기. Hash 기반의 set / dict에서 사용하자
2. dictionary에서 키에 접근하는 에러를 방지하기 위해, setdefault(key, value) 가 있다.
3. 5개의 container형 자료구조 (str, set, tuple, list, dictionary)를 정렬하기 위해선 sorted 함수 하나면 된다. 
  - sort는 '메서드'인데, set이랑 dictionary에는 없어서 좀 까다롭다.
4. 

'''
fruit = ['apple', 'grape', 'orange', 'banana']
price = [3200, 15200, 9800, 5000]
_dict = dict(zip(fruit, price))

print(_dict.setdefault('strawberry', 0)) # 0
print(_dict)


container1 = "rngmfsdoqasdcxvbfgcde"
container2 = (6,4,2,1,8,9,4,3,2)
container3 = [678,5,6,43,5,2624,8,2,21,1,6,7457,97]
container4 = {'b':2, 'a':1,  'c':3}
container5 = {'a','e','f','c', 'd', 'b'}

print(sorted(container1))
print(sorted(container2))
print(sorted(container3))
print(sorted(container4.items()))
print(sorted(container5))
