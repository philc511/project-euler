# see http://www.mathblog.dk/project-euler-114-fill-row-with-blocks/
# for approach used
fdict = [0] * 51

def f(n) :
  if n<3:
    return 1
  elif n==3 :
    return 2
  if fdict[n] > 0 :
    return fdict[n]
  c = 1
  for i in range( 3 , n+1 ):
    for j in range (n-i-1, -2, -1):
      c += f(j) 
  fdict[n] = c
  return c
   
print f(50)

