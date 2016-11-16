import unittest
import Euler

def problem036(n):
  total = 0
  for i in range(1,n):
    if(Euler.isPalindromic(i) and Euler.isBinaryPalindromic(i)):
      total = total + i
  return total

class TestProblem(unittest.TestCase):
    def test_simple(self):
        self.assertEquals(25, problem036(10))

#unittest.main()
	
print problem036(1000000)
  


