import unittest
#import Euler
#import time

# Pythagoran triples obtained via https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
# a+b+c = k*((m2 - n2) + 2mn + (m2 + n2)) = 2km(m+n)
buckets = [0] * 1001
for k in range(1,100):
  for m in range(2,  1000):
    for n in range(1,m):
      p = k*m*2*(m+n)
      if p==120:
        print k, m,n, k*(m*m-n*n), k*2*m*n, k*(m*m+n*n)
      if p<=1000:
        buckets[p]=buckets[p]+1
      else:
        break

print buckets[120]        
max=0
for i in range(0,1000):
  if(buckets[i] > max):
    max=buckets[i]
    print i,max
   
print 'donee'

            
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



