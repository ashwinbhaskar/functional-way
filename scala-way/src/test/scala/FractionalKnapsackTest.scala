import org.junit.Test
import org.junit.Assert._
import org.junit._
import greedy.maxValue

class FractionalKnapsackTest {
    @Test def happyPath() =  {
        val itemWeights = Array(4, 3, 2)
        val itemValues = Array(20, 18, 14)
        val maxCapacity = 7
        val optimalSolution = maxValue(itemWeights, itemValues, maxCapacity)
        assertTrue(optimalSolution == 42)
    }

    @Test def noWeightsGiven() =  {
        val itemWeights = Array[Int]()
        val itemValues = Array[Int]()
        val maxCapacity = 7
        val optimalSolution = maxValue(itemWeights, itemValues, maxCapacity)
        assertTrue(optimalSolution == 0)
    }
}
