package greedy

/*
Find the minimum stops for refueling required by a car on it's journey from point A to point B
*/

object MinimumRefuels extends App{
    /*
        stops: Array of distances at which fuel stations are present from point A
        distanceToPointB: Distance to point B from current station
        maxDistanceOnFullTank: The max distance the car can cover when it's tank is full
    */

    def minimumRefuels(stops: Array[Int], distanceToPointB: Int)(implicit maxDistanceOnFullTank: Int): Option[Int] = stops match {
        case Array(stop1, _ *) if stop1 > maxDistanceOnFullTank => None
        case _ => stops.indices.find(index => stops(index) >= maxDistanceOnFullTank) match {
            case Some(stopIndex) => 
                val greedyHopIndex = if(stops(stopIndex) == maxDistanceOnFullTank) stopIndex else stopIndex - 1
                val distanceCovered = stops(greedyHopIndex)
                val updatedStops = stops.drop(stopIndex).map(_ - distanceCovered)

                //Reduce the problem to problem of finding min refuels from current stop
                minimumRefuels(updatedStops, distanceToPointB - distanceCovered).map(_ + 1)
            case None => Some(0)
        }
    }
}

