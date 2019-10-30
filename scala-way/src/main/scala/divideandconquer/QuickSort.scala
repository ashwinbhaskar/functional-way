package divideandconquer

import scala.annotation.tailrec
import util.Utility.swap

/*
An implementation of the quick sort algorithm
 */

object QuickSort extends App{

  val arrayToSort = Array[Int](1,2,4,3,5,100,11,99,3,1,0,50)

  println(quickSort(arrayToSort).mkString(" "))

  def quickSort(arr: Array[Int]): Array[Int] = arr match {
    case Array() | Array(_) => arr
    case _ =>
      val pivotPos = arr.length/2
      val (newArray, finalPivotPos) = movePivotToCorrectPos(arr, pivotPos)
      quickSort(newArray.take(finalPivotPos)) ++ Array(newArray(finalPivotPos)) ++ quickSort(newArray.drop(finalPivotPos + 1))
  }

  def movePivotToCorrectPos(array: Array[Int], pivotPos: Int): (Array[Int], Int) = {
    val pivot = array(pivotPos)
    val lowIndex = 1
    val highIndex = array.length - 1

    @tailrec
    def recur(arr: Array[Int], lI: Int, hI: Int): (Array[Int], Int) =
      if(lI > hI) (arr, hI)
      else if (arr(lI) > pivot) {
        val newArray = swap(arr, lI, hI)
        recur(newArray, lI, hI - 1)
      } else {
        recur(arr, lI + 1, hI)
      }

    val mTemp = swap(array, 0, pivotPos)                   //move pivot to 0 index
    val (newArray, correctPivotPos) = recur(mTemp, lowIndex, highIndex)
    val finalArray = swap(newArray, 0, correctPivotPos)    //move pivot to correct pos
    (finalArray, correctPivotPos)
  }
}
