def is_palindrome(a):
  reverse = str(a)[::-1]
  return reverse == str(a)

def find_lychrel(a):
  next = a
  for i in range(50):
    next = next + int(str(next)[::-1])
#    print(next)
    if is_palindrome(next):
      return False 
  return True


lns=[]
for i in range(1,10000):
  if find_lychrel(i):
    lns.append(i)
print(len(lns))

