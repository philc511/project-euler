import itertools
import time
import Euler

# observation - a pair of primes with different modulo 3 values will not be prime pair (apart from those including 3 itself)

def is_concat_pair_prime(pair, sieve):
  return Euler.is_prime(int(str(pair[0]) + str(pair[1])), sieve) and Euler.is_prime(int(str(pair[1]) + str(pair[0])), sieve)
  

def look_for_pairs_of_pairs(pairs, sieve):
    for set in itertools.combinations(pairs, 2):
        if is_concat_pair_prime((set[0][0], set[1][0]), sieve) \
            and is_concat_pair_prime((set[0][0], set[1][1]), sieve) \
            and is_concat_pair_prime((set[0][1], set[1][0]), sieve) \
            and is_concat_pair_prime((set[0][1], set[1][1]), sieve):
            print(set)

PRIME_MAX=5000
sieve = Euler.sieveOfErasthenes(50000000)
primes=[]
for i in range(3,PRIME_MAX):
    if sieve[i] == 1:
        primes.append(i)
primes.remove(5)
print("done sieve")

prime_pairs_list_rem_1 = []
prime_pairs_list_rem_2 = []
for pair in itertools.combinations(primes, 2):
    if pair[0] % 3 + pair[1] % 3 == 0:
        # can't be prime
        break
    non_three = max(pair)
    if is_concat_pair_prime(pair, sieve):
        if non_three%3 == 1:
            prime_pairs_list_rem_1.append(pair)
        else:
            prime_pairs_list_rem_2.append(pair)

print("done creating array of pairs")

start =time.perf_counter()
# these will look for pairs of pairs (including duplicates, took 16 secs with PRIME_MAX=5000 on macbook)
#look_for_pairs_of_pairs(prime_pairs_list_rem_1, sieve)
#look_for_pairs_of_pairs(prime_pairs_list_rem_2, sieve)
# alt approach - add one more prime to the tuple, then another one

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

def generate_sets_with_remainder(req_remainder, primes, sieve):
    init_primes=[(3,)]
    for i in primes:
        if i%3 == req_remainder:
            init_primes.append((i,))
    pairs = expand_prime_sets(init_primes, primes, sieve, req_remainder)
    triples = expand_prime_sets(pairs, primes, sieve, req_remainder)
    quads = expand_prime_sets(triples, primes, sieve, req_remainder)
    for quad in quads:
        print(quad, sum(quad))
generate_sets_with_remainder(1, primes, sieve)
generate_sets_with_remainder(2, primes, sieve)
end= time.perf_counter()
print(end - start)
