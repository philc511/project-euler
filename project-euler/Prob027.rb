
def eachPrimeUpTo(n)
  candidates = Array.new(n, true)
  candidates[0] = false
  
  candidates.each_with_index do |candidate, i|
    if candidate then
      (2*i+1).step(n, i+1) do |index|
        candidates[index] = false
      end
    end
  end
  return candidates
end

def getSeqLen(a, b, primes)
  n = 1
  sum = b
  while primes[sum-1] do
	sum = n*n + a*n + b
	n += 1
  end
  return n-1
end

primes = eachPrimeUpTo(100000)
primes.each_with_index do | num, i |
  if num then
    #puts i+1
  end
end

# n^2 + a + b
maxSeqLen = 0
primes.each_with_index do |n,i|
  if n && i < 1000 then
    #puts i+1
    # b=i+1
    # try a=-b..42
	(-(i+1)..1000).each do |m|
	  seqLen = getSeqLen(m, i+1, primes)
	  #puts i+1
	  if seqLen > maxSeqLen then
	    print "b=",i+1, ", a=", m, ", ", seqLen,", a*b=", m*(i+1)
		puts
	    maxSeqLen = seqLen
	  end
	end
  end
end 

