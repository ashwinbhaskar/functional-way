import org.scalacheck.{Gen, Properties}
import org.scalacheck.Gen._
import org.scalacheck.Prop.forAll
import org.scalacheck.Arbitrary.arbitrary
import tree.transformBst

class TransformBstProperties extends Properties("TransformBST") {

  import tree.Node

  private val leafNodeGen : Gen[Node] = arbitrary[Int].map(v => Node(left = None, right = None, value = v))

  private val nodeGen = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(value = v, left = Some(left), right = Some(right))

  private val genTree : Gen[Node] = oneOf(nodeGen, leafNodeGen)

  /**
    @param node : The root node of the tree.
    @return True if zero is present in the tree (if the transformation when correct, there is guaranteed
                    to be zero.)
  */
  private def isZeroPresent(node : Option[Node]) : Boolean = node match {
    case Some(n) => if(n.value == 0) true else {
      isZeroPresent(n.left) || isZeroPresent(n.right)
    }
    case None => false
  }

  //Not a complete test here. But a good one to begin with
  property("transformBst") = forAll(genTree) { (root : Node) =>
    val transformedTreeRoot = transformBst(root)
    isZeroPresent(Some(transformedTreeRoot))
  }

}
