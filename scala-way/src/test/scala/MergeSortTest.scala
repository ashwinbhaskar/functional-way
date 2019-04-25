import divideandconquer.MergeSort
import org.scalatest.FunSuite
import util.Utility

class MergeSortTest extends FunSuite {



  test("MergeSort.merge") {
    val array1 = Utility.generateNumbers(size = 1000).sorted
    val array2 = Utility.generateNumbers(size = 1000).sorted
    val mergedArray = MergeSort.merge(array1, array2)
    assert(mergedArray.length === (array1.length + array2.length))
    assert(array1.forall(mergedArray.contains))
    assert(array2.forall(mergedArray.contains))
    assert(Utility.isSorted(mergedArray))
  }

  test("MergeSort.mergeSort"){
    val array = Utility.generateNumbers(size = 1000)
    val sortedArray = MergeSort.mergeSort(array)
    assert(sortedArray.length === array.length)
    assert(sortedArray.forall(array.contains))
    assert(Utility.isSorted(sortedArray))
  }

}
