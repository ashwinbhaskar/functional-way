
/*
Implements the merge sort algorithm to sort an array.
The functions mergeSort and merge are both pure functions
 */


object MergeSort extends App {

  val array = Array(1,2,4,2,100,44,1,2,1000,999,47)


  println(mergeSort(array).mkString(" "))



  def mergeSort(array : Array[Int]) : Array[Int] = array match {
    case Array(_) => array
    case Array() => array
    case a =>
      val midPoint = a.length/2
      val leftArray = mergeSort(a.take(midPoint))
      val righArray = mergeSort(a.drop(midPoint))
      merge(leftArray, righArray)
  }


  def merge(array1 : Array[Int], array2 : Array[Int]) : Array[Int] = (array1, array2) match {
    case (a,b) if a.isEmpty && b.isEmpty => Array[Int]()
    case (a,b) if a.isEmpty => b
    case (a,b) if b.isEmpty => a
    case (a,b) =>
      val (firstElement,a1, b1) = if(a.head < b. head) (a.head,a.tail,b) else (b.head, b.tail, a)
      firstElement +:  merge(a1,b1)
  }

}