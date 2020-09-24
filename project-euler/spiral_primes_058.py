import Euler
prime_count = 0

for i in range(1,50000):
  leading_diag = (2*i+1)*(2*i+1)
  if (Euler.is_prime(leading_diag-2*i) == 1):
    prime_count+=1
  if (Euler.is_prime(leading_diag-4*i) == 1):
    prime_count+=1
  if (Euler.is_prime(leading_diag-6*i) == 1):
    prime_count+=1
  ratio = 100*prime_count/(i*4+1)
  #print(2*i+1,prime_count, i*4+1, ratio)
  if (ratio < 10):
    print(2*i+1)
    break
  

