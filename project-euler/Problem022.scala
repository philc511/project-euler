def stringVal(s:String) = s.foldLeft(0)((a,b) => a + (b.toInt-64))

val s = new java.util.Scanner(new java.io.File("names.txt")).useDelimiter("\",?\"?")
var it = new scala.collection.jcl.MutableIterator.Wrapper(s)

val sortedList = it.toList.sort((a,b) => (a compareTo b) < 0)

var i = 1
var sum = 0

sortedList.foreach(a => { sum += i*stringVal(a); i+=1 })

println(sum)

