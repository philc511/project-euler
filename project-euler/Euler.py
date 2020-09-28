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
	
def is_prime(n, sieve = []):
    if n > len(sieve)-1:
        return is_prime_calc(n)
    return sieve[n]==1

def is_prime_calc(n):
    max_factor = int(sqrt(n))
    for i in range(2, max_factor+1):
        if n % i == 0:
            return False
    return True

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

def isPandigital(n):
  powers=[1,10,100,1000,10000,100000,1000000,10000000,100000000]
  if (n > 99999999 and n < 1000000000):
    total = 0
    while n > 0:
      digit = n%10
      total = total + powers[digit-1]*digit
      n = n / 10
    return total == 987654321
  else:
    return False
