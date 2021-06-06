import org.scalacheck.{Gen, Properties}
import org.scalacheck.Gen._
import org.scalacheck.Prop.forAll
import org.scalacheck.Arbitrary.arbitrary
import tree.transformBst

class TransformBstProperties extends Properties("TransformBST") {

  import tree.BinaryTree
  import tree.BinaryTree._

  private val leafNodeGen : Gen[BinaryTree[Int]] = arbitrary[Int].map(v => Node(left = Leaf, value = v, right = Leaf))

  private val nodeGen = for {
    v <- arbitrary[Int]
    left <- genTree
    right <- genTree
  } yield Node(value = v, left = left, right = right)

  private val genTree : Gen[BinaryTree[Int]] = oneOf(nodeGen, leafNodeGen)

  /**
    @param node : The root node of the tree.
    @return True if zero is present in the tree (if the transformation when correct, there is guaranteed
                    to be zero.)
  */
  private def isZeroPresent(node : BinaryTree[Int]) : Boolean = node match {
    case Node(left, value, right) => if(value == 0) true else {
      isZeroPresent(left) || isZeroPresent(right)
    }
    case Leaf => false
  }

  //Not a complete test here. But a good one to begin with
  property("transformBst") = forAll(genTree) { (root : BinaryTree[Int]) =>
    val transformedTreeRoot = transformBst(root)
    isZeroPresent(transformedTreeRoot)
  }

}
