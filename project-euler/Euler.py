from math import sqrt 

def sieveOfErasthenes(size):
    root = int(sqrt(size))
    
    # 1 is prime
    a = [1] * (size+1)
    a[1] = 0
    for j in range(2, root):
        if a[j] == 1:
            for k in range(j*j, size, j):
                a[k] = 0
    return a
	
def isPalindromic(n):
  a = n
  b=0
  while (a > 0):
    b = 10*b+a%10
    a = a/10
  return b == n

  
def isBinaryPalindromic(n):
  a = n
  b=0
  while (a > 0):
    b = 2*b+a%2
    a = a/2
  return b == n
