import itertools
import time
import Euler

def pairs(elements):
    res = []
    head, *tail = elements
    if len(elements) == 2:
        res.append((head, tail[0]))
    else:
        for elt in tail:
            res.append((head, elt))
        res+=pairs(tail)
    return res


def is_concat_pair_prime(pair, sieve):
  return Euler.is_prime(int(str(pair[0]) + str(pair[1])), sieve) and Euler.is_prime(int(str(pair[1]) + str(pair[0])), sieve)
  

PRIME_MAX=10000
SET_SIZE=4
sieve = Euler.sieveOfErasthenes(100000000)
primes=[]
for i in range(3,PRIME_MAX):
    if sieve[i] == 1:
        primes.append(i)
primes.remove(5)
print("done sieve")

prime_pairs_list = []
prime_pairs={}
for i in primes:
    for j in primes: 
        prime_pairs[(i,j)] = is_concat_pair_prime((i,j), sieve)
        prime_pairs[(j,i)] = prime_pairs[(i,j)]
        if is_concat_pair_prime((i,j), sieve) and i < j:
            prime_pairs_list.append((i,j))
print(len(prime_pairs_list))
print("done creating array of pairs")

start =time.perf_counter()
max_sum = 0
for set in itertools.combinations(primes,SET_SIZE):
    is_all_prime = True
    for pair in itertools.combinations(set,2):
        if not prime_pairs[pair]:
            is_all_prime = False
            break
    if is_all_prime:
        print(set)
        set_sum = sum(set)
        if set_sum > max_sum:
            max_sum = set_sum
            print(max_sum)
            break
end= time.perf_counter()
print(end - start)
