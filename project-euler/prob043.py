total = 0
def perms(prefix, a) :
  if len(a) == 1 :
    check (prefix * 10 + a[0])
  else :	
    for n in a:
      sublist = list(a)
      sublist.remove(n)
      perms(prefix*10 + n, sublist)

def check(n):
  global total
  n1=n % 1000
  if (n1 % 17) == 0 :
    n2 = (n/10) % 1000
    if (n2 % 13) == 0 :
      n3 = (n/100) % 1000
      if (n3 % 11) == 0 :
        n4 = (n/1000) % 1000
        if (n4 % 7) == 0 :
          n5 = (n/10000) % 1000
          if (n5 % 5) == 0 :
            n6 = (n/100000) % 1000
            if (n6 % 3) == 0 :
              n7 = (n/1000000) % 1000
              if (n7 % 2) == 0 :
                print n
                total = total + n

a = [0,1,2,3,4,5,6,7,8,9]
perms(0, a)
print total
