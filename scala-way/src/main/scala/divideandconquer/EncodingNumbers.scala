package divideandconquer
/*
 A B C D . . . Z is represented as 1 2 3 . . . 26

 A given number, eg "121" can be represented as "aba" or "la" or "au".
 As you can see there are 3 ways of encoding "121".

 In this program I will calculate the number of ways of 'encoding' an input number
 */

def getNumberOfWays(number : String) : Int = 
  def isPossible(n : Int) : Boolean = n <= 26 && n> 0
  def ways(list: List[Char]): Int = list match
    case Nil => 0
    case _ :: Nil => 1
    case first :: second :: Nil => if(isPossible(s"$first$second".toInt)) 2 else 1
    case _ => ways(list.tail) + ways(list.take(2)) - 1
  ways(number.toList)

@main def encodingNumbers = 
  val input: String = "121"
  println(getNumberOfWays(input))