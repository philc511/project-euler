# problem 34 
def sum_of_factorials(n):
    sum = 0
    while n > 0:
        sum += a[n % 10]
        n /= 10
    return sum
    
a = [1, 1, 2, 6, 24, 120, 720, 7*720, 7*8*720, 7*8*9*720]
print a

total = 0
for i in range(3, 3000000):
    if i == sum_of_factorials(i):
        total += i
#      print i
print total
