package divideandconquer

/*
Given an 2d matrix of Ints containing only
  1s : Road,
  0s : Trench,
  and one 9 : Goal

Find the shortest distance to reach Goal(9) starting from (0,0)

Constraints for moving - Up, Down, Left, Right
                         You can only move on Roads (1s). A trench(0) means you cannot move on that.

 */

object MatrixShortestDistance extends App {

  val input : Array[Array[Int]] = Array(Array(1,1,9),Array(1,0,1),Array(1,0,0))
  val TRENCH = 0
  val ROAD = 1
  val GOAL = 9
  val INFINITY = Int.MaxValue

  println(findShortestPath(input))

  def findShortestPath(inputMatrix : Array[Array[Int]]) : Int = {
    val startXY = (0,0)
    var visited = Set[(Int, Int)]()

    def isValid(point : (Int, Int)) : Boolean = point._1 >= 0 && point._1 < inputMatrix(0).length && point._2 >= 0 && point._2 < inputMatrix.length

    def getRoads(x : Int,y : Int) : List[(Int,Int)] = List((x+1,y),(x-1,y),(x,y+1),(x,y-1)).filter(p => isValid(p) && (inputMatrix(p._1)(p._2) == ROAD
      || inputMatrix(p._1)(p._2) == GOAL))

    def internalFunc(point : (Int,Int)) : Option[Int] = inputMatrix(point._1)(point._2) match {
      case GOAL => Some(0)
      case ROAD =>
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

    internalFunc(startXY).getOrElse(INFINITY)
  }



}
