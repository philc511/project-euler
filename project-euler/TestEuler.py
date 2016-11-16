import unittest
import Euler 

class TestEuler(unittest.TestCase):

  def test_seive(self):
    a = Euler.sieveOfErasthenes(25)
    self.assertEquals(0, a[1])
    self.assertEquals(1, a[2])
    self.assertEquals(1, a[3])
    self.assertEquals(0	, a[4])
    self.assertEquals(1, a[5])
    self.assertEquals(0, a[6])
    self.assertEquals(1, a[7])
    self.assertEquals(0, a[8])
    self.assertEquals(0, a[9])
    self.assertEquals(0, a[10])
    self.assertEquals(1, a[11])
    self.assertEquals(0, a[12])
    self.assertEquals(1, a[13])
    self.assertEquals(0, a[14])
    self.assertEquals(0, a[15])
    self.assertEquals(0, a[16])
    self.assertEquals(1, a[17])
    self.assertEquals(0, a[18])
    self.assertEquals(1, a[19])
    self.assertEquals(0, a[20])
    self.assertEquals(0, a[21])
    self.assertEquals(0, a[22])
    self.assertEquals(1, a[23])
    self.assertEquals(0, a[24])

  def test_isPalindromicTrue(self):
    self.assertTrue(Euler.isPalindromic(1234321))

  def test_isPalindromicFalse(self):
    self.assertFalse(Euler.isPalindromic(123432))


  def test_isBinaryPalindromicTrue(self):
    self.assertTrue(Euler.isBinaryPalindromic(0b10101))

  def test_isBinaryPalindromicFalse(self):
    self.assertFalse(Euler.isBinaryPalindromic(0b10111))

if __name__ == '__main__':
  unittest.main()

