object MatrixShortestDistance extends App {

  val input : Array[Array[Int]] = Array(Array(1,1,9),Array(1,0,1),Array(1,0,0))
  val trench = 0
  val road = 1
  val goal = 9
  val infinity = Int.MaxValue

  println(findShortestPath(input))

  def findShortestPath(inputMatrix : Array[Array[Int]]) : Int = {
    val startXY = (0,0)
    var visited = Set[(Int, Int)]()

    def isValid(point : (Int, Int)) : Boolean = point._1 >= 0 && point._1 < inputMatrix(0).length && point._2 >= 0 && point._2 < inputMatrix.length

    def getRoads(x : Int,y : Int) : List[(Int,Int)] = List((x+1,y),(x-1,y),(x,y+1),(x,y-1)).filter(p => isValid(p) && (inputMatrix(p._1)(p._2) == road
      || inputMatrix(p._1)(p._2) == goal))

    def internalFunc(point : (Int,Int)) : Option[Int] = inputMatrix(point._1)(point._2) match {
      case 9 => Some(0)
      case 1 =>
        visited = visited + point
        val filteredPoints = getRoads(point._1, point._2).filterNot(visited.contains)
        if(filteredPoints.isEmpty) None
        else {
          val paths : List[Int] = filteredPoints.map(p => internalFunc(p)).flatMap(a => if(a.isDefined) List(a.get) else List())
          getRoads(point._1, point._2).foreach(p => visited = visited + p)
          if(paths.isEmpty) None
          else Some(1 + paths.min)
        }
    }

    internalFunc(startXY).getOrElse(infinity)
  }



}
