package util

import scala.util.Random

object Utility {

  def isSorted[A](array: Array[A])(implicit ordering: Ordering[A]): Boolean = if (array.isEmpty) true
  else
    array.zip(array.tail).forall(pair => ordering.gteq(pair._2, pair._1))


  def generateNumbers(size: Int): Array[Int] = (1 to size).map(_ => Random.nextInt()).toArray

  def swap(arr: Array[Int], pos1: Int, pos2: Int): Array[Int] = {
    val elem1 = arr(pos1)
    val elem2 = arr(pos2)
    arr.updated(pos1, elem2).updated(pos2, elem1)
  }

}
