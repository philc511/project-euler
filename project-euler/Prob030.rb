# loop through 1 ...n adding the difference between i**5 and (i-1)**5
# bit more work when reaching a multiple of 10,100,1000 etc
factor=5
# array containg differences
diffs=[]
(1..9).each {|i| diffs[i]=(i**factor) - ((i-1)**factor) }
# special case at diffs[0] = -total of all the diffs as going from 9 to 0
diffs[0] = (1..9).inject(0) { |n,i| n - diffs[i] }
# use the max value to count up to as 5*9**5 + 8^5, ie about 300000, as above around this 
# sum of powers cannot be as much as the integer value
maxVal=factor * (9**factor) + 8**factor
sum = 0
(1..maxVal).inject do |n,i|
  if (n == (i-1)) then
    print i-1,": ",n,"\n"
    sum = sum+n
  end
  if (i%100000 == 0) then
    n = n+diffs[(i/100000) % 10]
  end
  if (i%10000 == 0) then
    n = n+diffs[(i/10000) % 10]
  end
  if (i%1000 == 0) then
    n = n+diffs[(i/1000) % 10]
  end
  if (i%100 == 0) then
    n = n+diffs[(i/100) % 10]
  end
  if (i%10 == 0) then
    n = n+diffs[(i/10) % 10]
  end
  n+diffs[i%10]
end
# take one off the sum as discounting 1
puts sum-1
