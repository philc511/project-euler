maxSum = 0
MAXN =100
for a in range(1,MAXN):
  for b in range(1,MAXN):
    n = pow(a,b)
    sum = 0
    while n > 0:
      sum += n % 10
      n = n // 10
    if sum > maxSum:
      maxSum = sum
print (maxSum)
