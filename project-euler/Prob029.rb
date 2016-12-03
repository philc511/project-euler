# Problem 29
# Most of 2,100 to whatever power will be unique, apart from when n has squares, cubes etc.
# Start with eg 3^2, ..3^100 will overlap with some of 9^2..9^100, 27^2..27^100, 81^2..81^100 (ie 4 numbers)
# Check this by looping through the 4 nos generating i*2, i*3..i*100. Add these to array and return the 
# number of unique elements (this is countMatches)
def countMatches(n)
  a = Array.new
  (1..n).each do |i| 
    (2..100).each do |j| 
      a << i*j
    end
  end
  a.uniq.length
end
a=0
# deal with 2,4,8,16,32,64
a=a+countMatches(6)
# deal with 3,9,27,81
a=a+countMatches(4)
# deal with 5,25
a=a+countMatches(2)
# deal with 6,36
a=a+countMatches(2)
#deal with 7,49
a=a+countMatches(2)
# deal with 10,100
a=a+countMatches(2)

# now for all other numbers exluding 2,3,4,5,6,7,8,9,10,16,25,27,32,36,49,64,81,100
# there are 99 unique values
a = a + (99-18)*99

puts a 