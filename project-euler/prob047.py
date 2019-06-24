import Euler
from math import sqrt 

def numPrimeFactors(sieve, n):
    max = int(sqrt(n))

    result = 0
    tmpN = n
    for i in range(2,max):
        if (sieve[i] == 1):
            while(tmpN % i == 0):
                result += 1
                tmpN /= i
    return result

def numDistinctPrimeFactors(sieve, n):
    max = int(sqrt(n))

    result = 0
    tmpN = n
    for i in range(2,n):
        if (sieve[i] == 1):
            if (n % i == 0): result += 1
    return result

sieve = Euler.sieveOfErasthenes(100000000)
print("Done seive")
n = 2*2*3*11*97*23*2*11

#print (numPrimeFactors(sieve,n))
#print (numDistinctPrimeFactors(sieve,n))
#print (numDistinctPrimeFactors(sieve,644))
#print (numDistinctPrimeFactors(sieve,645))

n = 1
p = 4
cont = 0
while(cont < p):
    if (numDistinctPrimeFactors(sieve, n) == p): 
        cont += 1
        n += 1
    else:
        cont = 0
        n += 1
    if (n % 1000000 == 0): print(n)
print(n-p)