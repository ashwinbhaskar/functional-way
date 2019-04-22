package divideandconquer
/*
Implements the merge sort algorithm to sort an array.
The functions mergeSort and merge are both pure functions
 */


object MergeSort extends App {

  val array = Array(1,2,4,2,100,44,1,2,1000,999,47)


  println(mergeSort(array).mkString(" "))



  def mergeSort(array : Array[Int]) : Array[Int] = array match {
    case Array() => array    //empty array
    case Array(_) => array   //array with 1 element
    case _ =>                //else
      val midPoint = array.length/2
      val leftArray = mergeSort(array.take(midPoint))
      val rightArray = mergeSort(array.drop(midPoint))
      merge(leftArray, rightArray)
  }


  def merge(array1 : Array[Int], array2 : Array[Int]) : Array[Int] = (array1, array2) match {
    case (Array(),Array()) => Array[Int]()    //Both arrays empty
    case (Array(),b) => b                     //array1 empty
    case (a,Array()) => a                     //array2 empty
    case (a,b) =>                             //array1 & array2 non-empty
      val (firstElement,a1, b1) = if(a.head < b. head) (a.head,a.tail,b) else (b.head, b.tail, a)
      firstElement +:  merge(a1,b1)
  }

}