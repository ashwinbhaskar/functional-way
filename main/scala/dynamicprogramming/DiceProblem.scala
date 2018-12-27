package dynamicprogramming

/*
Given a number 'n', n>=0, find out the number of ways the number 'n' can be reached
by rolling a 6-faced dice
 */

object DiceProblem extends App {

  def noOfWays(n : Int) : BigInt = n match {
    case 0 => 0
    case a if a <= 6 => 1 + (1 to a).map(i => noOfWays(a - i)).sum
    case _ =>
      val array = new Array[BigInt](n+1)
      array(0) = 0
      (1 to 6).foreach(i => array(i) = noOfWays(i))
      (7 to n).foreach( i =>
        array(i) = array(i-6) + array(i-5) + array(i-4) + array(i-3) + array(i-2) + array(i-1))
      array(n)
  }


}

