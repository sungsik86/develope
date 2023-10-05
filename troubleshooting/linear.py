import numpy as np

# 3 x 3 모양의 2차원 행렬(배열)을 만들기
A = np.random.rand(3,3)

A = np.array(A)
print(A)

# B에 A의 역행렬
B = np.linalg.inv(A)
print(B)

result = np.linalg.det(A)

# result에 A와 B의 행렬 곱 연산 결과
result = np.dot(A,B)

print(result)

# 2 x 2 모양의 2차원 배열(행렬)
A = np.random.rand(2,2)


A = np.array(A)
print(A)

e, v = None, None
# A의 eigen value 및 vector를 변수 e와 v에 
e,v = np.linalg.eig(A); v=v.T

print(e)
print(v)
