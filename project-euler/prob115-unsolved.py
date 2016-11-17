fdict = [0] * 51

def f(m, n) :
  if n<m:
    return 1
  elif n==m :
    return 2
  if fdict[n] > 0 :
    return fdict[n]
  c = 1
  for i in range( m , n+1 ):
    for j in range (n-i-1, -2, -1):
      c += f(m, j) 
  fdict[n] = c
  return c
   
print f(3, 7)

