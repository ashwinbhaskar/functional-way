package heapsort
/*
 Creates a Heap and exposes method to extract min element of the heap
 and also a method to get a sorted array
 */

class Heap[T : Manifest](val arr : Array[T])(implicit ordering : Ordering[T]) {


  private var heapSize : Int = arr.length

  implicit val comparison : (T,T) => Boolean = (a : T, b: T) => ordering.compare(a,b) < 0

  private val heap : Array[T] = createMinHeap( arr.clone)


  def getMin : T = removeHead(heap)

  def getAll : Array[T] = (0 until heapSize).map(_ => getMin).toArray

  private def removeHead(a : Array[T]) : T = {
    val head = a.head
    swap(heapSize-1, 0, a)
    heapSize = heapSize - 1
    trickleDown(0)(a)
    head
  }

  private def createMinHeap(inputArray : Array[T]) : Array[T] = {
    val heapSize = inputArray.length
    (heapSize/2 to 0 by -1).foreach(index => trickleDown(index)(inputArray))
    inputArray
  }

  private def trickleDown(index : Int)(implicit a: Array[T]) : Unit = {
    getLeastChildIndex(index, a).fold(ifEmpty = {})(f = {leastIndex =>
      val wasSwapped = swapIfConditionMatches(leastIndex, index, a)
      if(wasSwapped) trickleDown(leastIndex)
    })
  }

  private def swapIfConditionMatches(index1 : Int, index2 : Int, a : Array[T])(implicit condition : (T, T) => Boolean) :  Boolean = {
    if(condition(a{index1}, a{index2})) {
      swap(index1, index2,a)
      true
    }
    else false
  }

  private def swap(index1 : Int, index2 : Int, a : Array[T]) : Unit = {
    if(isValidIndex(index1) && isValidIndex(index2)){
      val temp = a{index1}
      a{index1} = a{index2}
      a{index2} = temp
    }
  }

  private def getLeastChildIndex(index : Int, a : Array[T]) : Option[Int] = {
    val (leftChildIndex, rightChildIndex) = (getLeftChildIndex(index, a), getRightChildIndex(index, a))
    (leftChildIndex,rightChildIndex) match {
      case (None, None) => None
      case (Some(i), None) => Some(i)
      case (None, Some(i)) => Some(i)
      case (Some(i), Some(j)) => if(ordering.compare(a{i}, a{j}) < 0) Some(i) else Some(j)
    }
  }

  private def isValidIndex(index : Int) : Boolean = index < heapSize && index >= 0

  private def getLeftChildIndex(index : Int, a : Array[T]) : Option[Int] = {
    val childIndex = (2*index) + 1
    Some(childIndex).filter(isValidIndex)
  }

  private def getRightChildIndex(index : Int, a : Array[T]) : Option[Int] = {
    val childIndex = (2*index) + 2
    Some(childIndex).filter(isValidIndex)
  }

}
