package util
import scala.language.implicitConversions

object Implicits {

  implicit def convertToString(list : List[Char]) : String = list.mkString("")

}
