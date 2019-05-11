package misc

object MergeMaps extends App{

  /**
  @param fn A function that takes in the values of conflicting keys in the map and returns
           a single value
  @param maps A sequence of maps that will be merged into the first map of the sequence

  @return The merged map
    **/
  def merge[T](fn : (T, T) => T ,maps : Map[String, T]*) : Map[String, T] = {
    val originalMap = maps.head
    maps.tail.foldLeft(z = originalMap)(op = {
      (acc, nextMap) =>
        nextMap.foldLeft(z = acc)(op = {
          (acc1, mapEntry) => acc1.get(mapEntry._1) match {
            case Some(value) => acc1 + (mapEntry._1 -> fn(value, mapEntry._2))
            case None => acc1 + mapEntry
          }
        })
    })
  }

  val map1 : Map[String, Int] = Map("1" -> 1, "2" -> 4)
  val map2 : Map[String, Int] = Map("1" -> 3, "3" ->5)
  val fn : (Int, Int) => Int= _ + _

  val mergedMap = merge[Int](fn, map1, map2)
  println(mergedMap)

}
