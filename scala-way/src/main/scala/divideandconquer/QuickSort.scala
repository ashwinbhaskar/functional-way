package divideandconquer

/*
An implementation of the quick sort algorithm
 */

def quickSort(arr: Array[Int]): Array[Int] = arr match
    case Array() | Array(_) => arr
    case _ =>
      val pivotPos = arr.length/2
      val pivot = arr(pivotPos)
      val withoutPivot = arr diff Array(pivot)
      quickSort(withoutPivot.filter(_ < pivot)) ++ Array(pivot) ++ quickSort(withoutPivot.filterNot(_ < pivot))

@main def quickSorter = 
  val arrayToSort = Array[Int](1,2,4,3,5,100,11,99,3,1,0,50)
  println(quickSort(arrayToSort).mkString(" "))
