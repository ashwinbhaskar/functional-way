import org.scalatest.FunSuite
import greedy.MinimumRefuels

class MinRefuelsTest extends FunSuite {

    test("Should return the correct min refuels when solution is possible"){
        val stops = Array(10,40,70,80)
        val minRefuels = MinimumRefuels.minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 30)
        assert(minRefuels == Some(3))
    }

    test("Should return none if there solution is not possible"){
        val stops = Array(10,50,70,80)
        val minRefuels = MinimumRefuels.minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 30)
        assert(minRefuels == None)
    }

    test("Should return 0 when no stops are required"){
        val stops = Array(10,50,70,80)
        val minRefuels = MinimumRefuels.minimumRefuels(stops = stops, distanceToPointB = 100)(maxDistanceOnFullTank = 101)
        assert(minRefuels == Some(0))
    }

}