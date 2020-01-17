import divideandconquer.quickSort
import org.scalacheck.Properties
import util.Utility
import org.scalacheck.Prop.forAll


class QuickSortProperties extends Properties(name = "QuickSort"){

  property("quickSort") = forAll { (array : Array[Int]) =>
    val quickSortedArray = quickSort(array)
    quickSortedArray.length == array.length && Utility.isSorted(quickSortedArray)
  }

}
