import divideandconquer.mergeSort
import divideandconquer.merge
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import util.Utility


class MergeSortProperties extends Properties("MergeSort"){

  property("merge") = forAll { (array1 : Array[Int], array2 : Array[Int]) =>
    val mergedArray = merge(array1.sorted, array2.sorted)
    (mergedArray.length == (array1.length + array2.length)) && Utility.isSorted(mergedArray)
  }

  property("mergeSort") = forAll { (array : Array[Int]) =>
    val mergeSortSorted = mergeSort(array)
    (mergeSortSorted.length == array.length) && Utility.isSorted(mergeSortSorted)
  }

}
