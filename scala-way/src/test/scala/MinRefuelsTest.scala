import org.junit.Test
import org.junit.Assert._
import org.junit._
import greedy.minimumRefuels

class MinRefuelsTest {

    @Test def happyPathTest() = {
        val stops = Array(10,40,70,80)
        val minRefuels = minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 30)
        assertTrue(minRefuels == Some(3))
    }

    @Test def noSolutionPossible() = {
        val stops = Array(10,50,70,80)
        val minRefuels = minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 30)
        assertTrue(minRefuels == None)
    }

    @Test def noStopsRequired() = {
        val stops = Array(10,50,70,80)
        val minRefuels = minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 101)
        assertTrue(minRefuels == Some(0))
    }

}
