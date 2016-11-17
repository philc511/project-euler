#!/usr/bin/env python

import math
import Euler

def all_cyclic_prime(n, num_digits):
	multiplier = int(math.pow(10,num_digits-1))
	cyclic_n = n
	for i in range(0,num_digits):
		if (arr[cyclic_n] == 0):
			return False
		cyclic_n = multiplier*(cyclic_n%10) + cyclic_n/10
	return True


n = 1000
arr = Euler.sieveOfErasthenes(n*n)
print "prime"
#for i in range(0,n*n):
#  if (arr[i] == 0):
#      print i+1

print "not prime"
#for i in range(0,n*n):
#  if (arr[i] == 1):
#    print i+1
count = 0
for i in range (2, 10):
	if all_cyclic_prime(i,1):
		print i
		count = count +1
for i in range(10,100):
	if all_cyclic_prime(i,2):
		print i
		count = count +1
for i in range(100,1000):
	if all_cyclic_prime(i,3):
		print i
		count = count +1
for i in range(1000,10000):
	if all_cyclic_prime(i,4):
		print i
		count = count +1
for i in range(10000,100000):
	if all_cyclic_prime(i,5):
		print i
		count = count +1
for i in range(100000,1000000):
	if all_cyclic_prime(i,6):
		print i
		count = count +1
print count
