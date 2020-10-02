import itertools
import time
import Euler

# observation - a pair of primes with different modulo 3 values will not be prime pair (apart from those including 3 itself)
# so separate out primes into two lists,  p mod 3 = 1 and p mod 3 = 2 (3 itself in both lists
# Then for each of these start with list of primes, then check all primes above the 
# max of these to see if it can be added to make a valid pair.
# Repeat on each pair to make a tripe, quadruplet then finally again to make five.
# Took about a week of playing with this, after trying brute force and other approaches which were all too slow

# function to check if a pair is prime, ie concatenating the numbers in either order gives a prime number
def is_concat_pair_prime(pair, sieve):
  return Euler.is_prime(int(str(pair[0]) + str(pair[1])), sieve) and Euler.is_prime(int(str(pair[1]) + str(pair[0])), sieve)
  
# take a list of sets (n-tuples) and find primes which can be added to that tuple to make a list of n+1-tuples (for primes where p mod 3 = req_remainder
def expand_prime_sets(prime_sets_in, primes, sieve, req_remainder):
    prime_sets_out = []
    for p in prime_sets_in:
        min_prime = max(p)
        for i in primes:
            if i > min_prime and i%3==req_remainder:
                is_prime = True
                for j in p:
                    if not is_concat_pair_prime((i,j), sieve):
                        is_prime = False
                        break
                if is_prime:
                    prime_sets_out.append(p + (i,))
    return prime_sets_out

# starting from a list of primes (p mod 3 = req_remainder), iteratively create a list of
# size-tuples, by making pairs from the primes then triples from those, etc
def generate_sets_with_remainder(size, req_remainder, primes, sieve):
    res=[(3,)]
    for i in primes:
        if i%3 == req_remainder:
            res.append((i,))
    for i in range(size-1):
        res = expand_prime_sets(res, primes, sieve, req_remainder)
    return res

set_size = 5 
PRIME_MAX=10000
sieve = Euler.sieveOfErasthenes(100000000)
primes=[]
for i in range(3,PRIME_MAX):
    if sieve[i] == 1:
        primes.append(i)
primes.remove(5)
print("done sieve")

start =time.perf_counter()

sets = generate_sets_with_remainder(set_size, 1, primes, sieve)
sets = sets + generate_sets_with_remainder(set_size, 2, primes, sieve)
min_sum = set_size * PRIME_MAX
for i in sets:
    min_sum = min(min_sum, sum(i))
print(min_sum)

end= time.perf_counter()
print(end - start)
