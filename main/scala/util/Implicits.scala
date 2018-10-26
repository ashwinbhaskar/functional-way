package util

object Implicits {

  implicit def convertToString(list : List[Char]) : String = list.mkString("")

}
