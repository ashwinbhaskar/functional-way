package divideandconquer
/*

 */

object QuickSort extends App{

  val arrayToSort = Array[Int](1,2,4,3,5,100,11,99,3,1,0,50)

  println(quickSort(arrayToSort).mkString(" "))

  def quickSort(inputArray : Array[Int]) : Array[Int] = inputArray match {
    case Array() => inputArray
    case Array(_) => inputArray
    case _ =>
    val initialPivotPos = inputArray.length/2
    val finalPivotPos = giveFinalPivotPosAndModifyArray(initialPivotPos,inputArray)
    quickSort(inputArray.take(finalPivotPos)) ++ Array(inputArray{finalPivotPos}) ++ quickSort(inputArray.drop(finalPivotPos+1))
  }

  def swap(pos1 : Int, pos2 : Int)(array : Array[Int]) : Unit = {
    val temp = array{pos1}
    array{pos1} = array{pos2}
    array{pos2} = temp
  }

  def giveFinalPivotPosAndModifyArray(initialPivotPos : Int,array : Array[Int]) : Int = {
    def internalFunc(headPos : Int, tailPos : Int): Int = (headPos, tailPos) match {
      case _ if headPos > tailPos => tailPos
      case _ => if(array{headPos} > array{0}){
        swap(headPos,tailPos)(array)
        internalFunc(headPos,tailPos-1)
      } else internalFunc(headPos+1, tailPos)
    }
    swap(0,initialPivotPos)(array)
    val finalPivotPos = internalFunc(1,array.length-1)
    swap(0,finalPivotPos)(array)
    finalPivotPos
  }

}
