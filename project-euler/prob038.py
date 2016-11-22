import unittest
import Euler
import time

            
def problem038(nrange):
  answer = 0
  for i in nrange:
    for j in range(1,9999):
      a = concatenatedNum(j,i)
      if (a > 999999999):
        break
      if Euler.isPandigital(a):
        print i,j,a
        if (a > answer):
          answer = a
  return answer

  
def concatenatedNum(p,n):
  total=0
  multiple=1
  for i in range(n,0,-1):
    a = i*p
    total = total + multiple * a
    multiple = multiple * getMultiple(a)
  return total
    
    
def getMultiple(n):
  ret = 1
  while n > 0:
    n = n/10
    ret = ret*10
  return ret
  
class TestProblem(unittest.TestCase):
    def test_simple(self):
        self.assertEquals(123456789, problem038(range(9,10)))
        
    def test_getMultiple(self):
        self.assertEquals(1000, getMultiple(192))
        self.assertEquals(10, getMultiple(9))
        self.assertEquals(1000000, getMultiple(999192))
        
    def test_concatenateNum(self):
      self.assertEquals(192384576, concatenatedNum(192,3))
        

#unittest.main()

t0 = time.time()
print problem038(range(2,10))
t1 = time.time()
total1 = t1-t0

t0 = time.time()
# borrow a string based solution to compare...https://projecteuler.net/thread=38;page=2
for a in xrange(10000) :
    num_str = ""
    for b in xrange(1, 10) :
        num_str += str(a * b)
        
        if len(num_str) >= 9 :
            break
            
    if len(num_str) == 9 :
        found = True
        for i in xrange(1,10) :
            if str(i) not in num_str :
                found = False
                
        if found :
            print a, num_str
t1 = time.time()
total2 = t1-t0

print total1
print total2
