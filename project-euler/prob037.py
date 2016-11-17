import unittest
import Euler

power_of_ten = 6
sieve = Euler.sieveOfErasthenes(pow(10,power_of_ten))

def is_prime(n):
  return sieve[n] == 1
  
def is_right_truncatable(n):
  if is_prime(n):
    if n < 10:
      return True
    else:
      return is_right_truncatable(n / 10)
  else:
    return False
    
def is_left_truncatable(n, tenth_power):
  if is_prime(n):
    if n < 10:
      return True
    else:
      return is_left_truncatable(n % tenth_power, tenth_power / 10)
  else:
    return False
            
def problem037(n):
  truncatables = []
  for i in range(1,n):
    start = pow(10,i)
    for j in range(start, pow(10,i+1)):
      if is_right_truncatable(j) and is_left_truncatable(j, start):
        truncatables.append(j)
  return sum(truncatables)

  
  
class TestProblem(unittest.TestCase):
    def test_simple(self):
        self.assertEquals(186, problem037(2))
        
    def test_is_right_truncatable(self):
      self.assertTrue(is_right_truncatable(37))
      self.assertFalse(is_right_truncatable(47))

    def test_is_left_truncatable(self):
      self.assertTrue(is_left_truncatable(37, 10))
      self.assertFalse(is_left_truncatable(19, 10))

#unittest.main()
print problem037(power_of_ten)
	
  


