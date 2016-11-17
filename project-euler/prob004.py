import Euler

maxPalindrome = 0
for i in range(999, 100, -1):
    for j in range(999, 100, -1):
        if Euler.isPalindromic(i * j) and (i*j) > maxPalindrome:
            maxPalindrome = (i * j)

print maxPalindrome