package util

import scala.util.Random

object Utility {

  def isSorted[A](array : Array[A])(implicit ordering : Ordering[A]) : Boolean = {
    array.zip(array.tail).forall(pair => ordering.gteq(pair._2, pair._1))
  }

  def generateNumbers(size : Int) : Array[Int] = (1 to size).map(_ => Random.nextInt()).toArray

}
