import Euler

import itertools

def checkPerms(p, sieve):
    perms = itertools.permutations(str(p))
    relatedPrimes = []
    # get list of primes which are > p
    for iTuple in perms:
        i = int(''.join(iTuple))
        if (sieve[i] == 1 and i > p): relatedPrimes.append(i)
    
    # then look for average of p and each n in list and check whether this is in the list
    for i in relatedPrimes:
        if((p+i)/2) in relatedPrimes:
            print(p, (p+i)/2, i)


sieve = Euler.sieveOfErasthenes(10000)

for i in range(1001,10000):
    if (sieve[i] == 1): checkPerms(i, sieve)
