object HeapSort extends App {

  val array = Array(1,2,4,2,100,44,1,2,1000,999,47)

  println(createMinHeap(array).mkString(" "))

  def createMinHeap(array : Array[Int]) : Array[Int] = {
    val heapSize = array.length
    (heapSize/2 to 0).foreach(index => {
      val leastChildIndex = getLeastChildIndex(index)(array)
      if(leastChildIndex.isDefined) swapIfConditionMatches(leastChildIndex.get,index)(array)((childIndex, parentIndex) => array{childIndex} < array{parentIndex})
    })
    array
  }

  def swapIfConditionMatches(index1 : Int, index2 : Int)(array: Array[Int])(condition : (Int, Int) => Boolean) : Array[Int] = {
    if(condition(index1, index2)) swap(index1, index2)(array)
    else array
  }

  def swap(index1 : Int, index2 : Int)(array : Array[Int]) : Array[Int] = {
    if(isValidIndex(index1)(array) && isValidIndex(index2)(array)){
      val temp = array{index1}
      array{index1} = array{index2}
      array{index2} = temp
      array
    }else array
  }

  def getLeastChildIndex(index : Int)(array : Array[Int]) : Option[Int] = {
    val (leftChildIndex, rightChildIndex) = (getLeftChildIndex(index)(array), getRightChildIndex(index)(array))
    (leftChildIndex,rightChildIndex) match {
      case (None, None) => None
      case (Some(i), None) => Some(i)
      case (None, Some(i)) => Some(i)
      case (Some(i), Some(j)) => if(array{i} < array{j}) Some(i) else Some(j)
    }
  }

  def isValidIndex(index : Int)(array : Array[Int]) : Boolean = index < array.length && index >= 0

  def getLeftChildIndex(index : Int)(array : Array[Int]) : Option[Int] = {
    val childIndex = (2*index) + 1
    if(isValidIndex(childIndex)(array)) Some(childIndex) else None
  }

  def getRightChildIndex(index : Int)(array : Array[Int]) : Option[Int] = {
    val childIndex = (2*index) + 2
    if(isValidIndex(childIndex)(array))  Some(childIndex) else None
  }

  def getParentIndex(index : Int) : Int = index%2 match {
    case 0 => (index - 2)/2
    case _ => (index - 1)/2
  }

}
