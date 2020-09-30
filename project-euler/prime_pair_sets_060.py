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
sieve = Euler.sieveOfErasthenes(100000000)
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

end= time.perf_counter()
print(end - start)
