import org.scalacheck.{Gen, Properties}
import org.scalacheck.Gen._
import org.scalacheck.Prop.forAll
import org.scalacheck.Arbitrary.arbitrary
import tree.transformBst
import tree.MaybeNode

class TransformBstProperties extends Properties("TransformBST") {

  import tree.Node

  private val leafNodeGen : Gen[Node] = arbitrary[Int].map(v => Node(left = null, right = null, value = v))

  private val nodeGen = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(value = v, left = left, right = right)

  private val genTree : Gen[Node] = oneOf(nodeGen, leafNodeGen)

  /**
    @param node : The root node of the tree.
    @return True if zero is present in the tree (if the transformation when correct, there is guaranteed
                    to be zero.)
  */
  private def isZeroPresent(node : MaybeNode) : Boolean = node match {
    case n: Node => if(n.value == 0) true else {
      isZeroPresent(n.left) || isZeroPresent(n.right)
    }
    case null => false
  }

  //Not a complete test here. But a good one to begin with
  property("transformBst") = forAll(genTree) { (root : Node) =>
    val transformedTreeRoot = transformBst(root)
    isZeroPresent(transformedTreeRoot)
  }

}
