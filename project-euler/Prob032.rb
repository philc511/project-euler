(1..9).each do |i| 
  (1..9).each do |j|
    (1..9).each do |k|
	  a = (10.0*i+j)/(10.0*j+k) - 1.0*i/k
	  if (a > -0.001 && a < 0.001) then
	    print 10.0*i+j,"/ ", 10.0*j+k, ",    ",i," / ", k, ",   ",j,"\n"
	  end
	end
  end
end