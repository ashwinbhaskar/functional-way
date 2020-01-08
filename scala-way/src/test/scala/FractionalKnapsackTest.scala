import org.scalatest.FunSuite
import greedy.{FractionalKnapsack => fk}

class FractionalKnapsackTest extends FunSuite {
    test("Should return the correct max value") {
        val itemWeights = Array(4, 3, 2)
        val itemValues = Array(20, 18, 14)
        val maxCapacity = 7
        val optimalSolution = fk.maxValue(itemWeights, itemValues, maxCapacity)
        assert(optimalSolution == 42)
    }

    test("Should return 0 when there are no weights") {
        val itemWeights = Array[Int]()
        val itemValues = Array[Int]()
        val maxCapacity = 7
        val optimalSolution = fk.maxValue(itemWeights, itemValues, maxCapacity)
        assert(optimalSolution == 0)
    }
}