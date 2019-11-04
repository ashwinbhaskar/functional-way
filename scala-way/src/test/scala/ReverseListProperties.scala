import misc.ReverseList
import org.scalacheck.{Arbitrary, Cogen, Prop, Properties}
import org.scalacheck.Prop.forAll

class ReverseListProperties extends Properties(name = "ReverseList"){

  property("reverse/Int") = reverseProp[Int]
  property("reverse/String") = reverseProp[String]

  private def reverseProp[T : Arbitrary : Cogen]: Prop = {
    forAll{ list: List[T] =>
      val reverseList = ReverseList.reverse(list)
      reverseList == list.reverse
    }
  }

}
