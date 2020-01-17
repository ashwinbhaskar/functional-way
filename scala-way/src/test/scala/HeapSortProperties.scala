import heapsort.heapSort
import org.scalacheck.Properties
import util.Utility
import org.scalacheck.Prop.forAll

class HeapSortProperties extends Properties("HeapSort") {

  property("apply") = forAll { (array : Array[Int]) =>
    val sortedArray = heapSort(array)
    (sortedArray.length == array.length) && Utility.isSorted(sortedArray)
  }

}
