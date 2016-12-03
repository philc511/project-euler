class CoinCounter
  def initialize()
    @targetValue = targetValue
  end
  def count()
    @target
    howManyCoins
end

def howManyCoins(current, sum, n, targetValue)
  coins = [1,2,5,10,20,50,100,200]
  if (sum == targetValue) then
    1
  elsif (sum > targetValue) then
    0
  elsif (n>1) then
      ret = 0
      coins.inject(0) do |result, element|
          if (current <= element) then
              result + howManyCoins(element, sum+element, n-1, targetValue)
          else
              result
          end
      end
  else
  #puts sum
    0
  end
end
# make a class, call a neater starting method?
puts howManyCoins(0, 0, 201, 200) 
