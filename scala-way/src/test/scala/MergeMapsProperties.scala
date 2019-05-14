import org.scalacheck._
import misc._

class MergeMapsProperties extends Properties(name = "MergeMaps") {

  import Prop.BooleanOperators

  property("merge/int") = mergeProp[Int]
  property("merge/string") = mergeProp[String]
  // runs green, but 100 iterations take quite some time...
  // property("merge/map") = mergeProp[Map[String, Int]]

  private def mergeProp[T : Arbitrary : Cogen]: Prop =
    Prop.forAll { (ms: Seq[Map[String, T]], f: (T, T) => T) =>
      ms.nonEmpty ==> {
        val allKeys = ms.map(_.keySet).reduce(_ ++ _)
        def expVal(k: String): T = ms.flatMap(_.get(k).toSeq).reduceLeft(f)
        val res = MergeMaps.merge(f, ms:_*)
        res.keySet == allKeys && allKeys.forall(k => res(k) == expVal(k))
        // Actually this is an alternative implementation of MergeMaps... :/
        // val exp = allKeys.map(k => (k, expVal(k))).toMap
        // res == exp
      }
    }


}
