import itertools
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
  
PRIME_MAX=1000
sieve = Euler.sieveOfErasthenes(PRIME_MAX)
primes=[]
for i in range(3,PRIME_MAX):
    if sieve[i] == 1:
        primes.append(i)

max_sum = 0
for set in itertools.combinations(primes,4):
    is_all_prime = True
    for pair in itertools.combinations(set,2):
        if not is_concat_pair_prime(pair, sieve):
            is_all_prime = False
            break
    if is_all_prime:
        print(set)
        set_sum = sum(set)
        if set_sum > max_sum:
            max_sum = set_sum
        break
print(max_sum)
