package heapsort

object HeapSort extends App {

  val array : Array[Int] = Array[Int](1,2,100,2,3,100,2,3,1,34,99,98,90,89,100)

  val heap = new Heap[Int](array)

  println(heap.getAll.mkString(" "))


}
