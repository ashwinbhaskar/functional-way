package heapsort
/*
 Creates a Heap and exposes method to extract min element of the heap
 and also a method to get a sorted array
 */

class Heap[T : Manifest](val arr : Array[T])(implicit ordering : Ordering[T]) {


  private implicit var heapSize : Int = arr.length

  implicit val comparison : (T,T) => Boolean = (a : T, b: T) => ordering.compare(a,b) < 0

  private val heap : Array[T] = createMinHeap( arr.clone)


  def getMin : T = removeHead(heap)

  def getAll : Array[T] = (0 until heapSize).map(_ => getMin).toArray

  private def removeHead(array : Array[T]) : T = {
    val head = array.head
    swap(heapSize-1, 0)(array)
    heapSize = heapSize - 1
    trickleDown(0)(array)
    head
  }

  private def createMinHeap(inputArray : Array[T]) : Array[T] = {
    val heapSize = inputArray.length
    (heapSize/2 to 0 by -1).foreach(index => trickleDown(index)(inputArray))
    inputArray
  }

  private def trickleDown(index : Int)(implicit array : Array[T]) : Unit = {
    val leastChildIndex = getLeastChildIndex(index)
    if(leastChildIndex.isDefined) {
      val wasSwapped = swapIfConditionMatches(leastChildIndex.get, index)
      if(wasSwapped){
        trickleDown(leastChildIndex.get)
      }
    }
  }

  private def swapIfConditionMatches(index1 : Int, index2 : Int)(implicit array: Array[T],  condition : (T, T) => Boolean) :  Boolean = {
    if(condition(array{index1}, array{index2})) {
      swap(index1, index2)(array)
      true
    }
    else false
  }

  private def swap(index1 : Int, index2 : Int)(implicit array : Array[T]) : Unit = {
    if(isValidIndex(index1) && isValidIndex(index2)){
      val temp = array{index1}
      array{index1} = array{index2}
      array{index2} = temp
    }
  }

  private def getLeastChildIndex(index : Int)(implicit array : Array[T]) : Option[Int] = {
    val (leftChildIndex, rightChildIndex) = (getLeftChildIndex(index)(array), getRightChildIndex(index)(array))
    (leftChildIndex,rightChildIndex) match {
      case (None, None) => None
      case (Some(i), None) => Some(i)
      case (None, Some(i)) => Some(i)
      case (Some(i), Some(j)) => if(ordering.compare(array{i}, array{j}) < 0) Some(i) else Some(j)
    }
  }

  private def isValidIndex(index : Int)(implicit size : Int) : Boolean = index < size && index >= 0

  private def getLeftChildIndex(index : Int)(implicit array : Array[T]) : Option[Int] = {
    val childIndex = (2*index) + 1
    if(isValidIndex(childIndex)) Some(childIndex) else None
  }

  private def getRightChildIndex(index : Int)(implicit array : Array[T]) : Option[Int] = {
    val childIndex = (2*index) + 2
    if(isValidIndex(childIndex))  Some(childIndex) else None
  }

  private def getParentIndex(index : Int) : Int = index%2 match {
    case 0 => (index - 2)/2
    case _ => (index - 1)/2
  }

}
