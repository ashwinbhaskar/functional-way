package heapsort

object HeapSort extends App {

  private def swap(arr: Array[Int], i1: Int, i2: Int): Array[Int] = {
    val elem1 = arr(i1)
    arr.updated(i1, arr(i2)).updated(i2, elem1)
  }

  private def heapifyMax(arr: Array[Int], root: Int, heapSize: Int): Array[Int] = {
    val rootIdx = root
    val lIdx = (root + 1) * 2 - 1
    val rIdx = (root + 1) * 2
    (arr.lift(rootIdx), arr.lift(lIdx), arr.lift(rIdx)) match {
      case (Some(p), Some(l), Some(r)) if r > l && r > p && heapSize >= rIdx =>
        heapifyMax(swap(arr, rIdx, rootIdx), rIdx, heapSize)
      case (Some(p), Some(l), _) if l > p && heapSize >= lIdx =>
        heapifyMax(swap(arr, lIdx, rootIdx), lIdx, heapSize)
      case _ => arr
    }
  }

  private def buildMaxHeap(arr: Array[Int]): Array[Int] = {
    (Math.floor(arr.length / 2).toInt - 1 to 0 by -1).foldLeft(arr)(heapifyMax(_, _, arr.length))
  }

  def apply(arr: Array[Int]): Array[Int] = {
    (arr.length - 1 to 0 by -1).foldLeft(buildMaxHeap(arr))((b, a) => heapifyMax(swap(b, 0, a), 0, a - 1))
  }

  println(heapifyMax(Array(1, 4, 5, 2, 4, 3, 5), 0, 7).deep)
  println(buildMaxHeap(Array(7, 4, 3, 0, 2, 1, 9, 5, 6)).deep)
  println(apply(Array(7, 4, 3, 0, 2, 1, 9, 5, 6)).deep)
  println(apply((1 to 1000).map(_ => scala.util.Random.nextInt()).toArray).deep)

}
