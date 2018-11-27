package divideandconquer
/*
 A B C D . . . Z is represented as 1 2 3 . . . 26

 A given number, eg "121" can be represented as "aba" or "la" or "abt".
 As you can see there are 3 ways of encoding "121".

 In this program I will calculate the number of ways of 'encoding' an input number
 */

object EncodingNumbers extends App {

  val encoding : Array[Char] = ('a' to 'z').toArray

  val inputNumber : String = "121"

  println(getNumberOfWays(inputNumber))

  def getNumberOfWays(number : String) : Int = {

    def isPossible(n : Int) : Boolean = n <=26 && n>0

    def ways(list: List[Char]): Int = list match {
      case Nil => 1
      case _ :: Nil => 1
      case _ => ways(list.tail) +
        (if(isPossible(list.take(2).foldLeft("")((acc,ch) => s"$acc$ch").toInt))
          ways(list.drop(2))
        else 0 )
    }

    ways(number.toList)
  }
}
