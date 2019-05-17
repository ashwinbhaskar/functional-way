package tree
/*
Given a BST transform it to a Binary Tree where every node is replaced with the sum of
all the node greater than the node. If there are no nodes greater than the node, replace it's value with 0
Eg :-
    5                        27
   / \                      /  \
  2    7        =>         32   8
 /    / \                 /    / \
1    6   8               34   21  0
      \                        \
       6                        15

 */

object TransformBST extends App {


  val root : Node = {
    val leaf1 = Node(1, None, None)
    val leaf2 = Node(6, None, None)
    val leaf3 = Node(8, None, None)
    val interim1 = Node(2, Some(leaf1), None)
    val interim3 = Node(6, None, Some(leaf2))
    val interim2 = Node(7, Some(interim3), Some(leaf3))
    Node(5, Some(interim1), Some(interim2))
  }


  val transformedRoot = transformBst(root)
  println(s"transformed root value = ${transformedRoot.value}")

  /**
   @param root The root node of the tree to be transformed.
   @return The root node of the transformed tree
   */
  def transformBst(root: Node): Node = {
    def internalFunc(node: Option[Node], nodeType: NodeType, parentWeight: Int, origParentValue: Int): Option[Node] = node match {
      case Some(n) =>
        val transformedValue = nodeType match {
          case PureType => sumRightChildren(n)
          case RightNodeType => sumRightChildren(n) + parentWeight
          case LeftNodeType => sumRightChildren(n) + parentWeight + origParentValue
        }
        val rightChild = internalFunc(n.right, nodeType = RightNodeType && nodeType, parentWeight = parentWeight + origParentValue, origParentValue = n.value)
        val leftChild = internalFunc(n.left, nodeType = LeftNodeType && nodeType, parentWeight = transformedValue, origParentValue = n.value)
        Some(Node(transformedValue, left = leftChild, right = rightChild))
      case None =>
        None
    }

    internalFunc(Some(root), nodeType = PureType, parentWeight = 0, origParentValue = 0).get
  }

  def sumRightChildren(node: Node): Int = {
    def internalFunc(a: Option[Node]): Int = a match {
      case Some(n) => n.value + internalFunc(n.left) + internalFunc(n.right)
      case None => 0
    }

    internalFunc(node.right)
  }


}

case class Node(value: Int, left: Option[Node], right: Option[Node])

sealed trait NodeType {
  def &&(anotherNode: NodeType): NodeType = (this, anotherNode) match {
    case (a, b) if a == b => a //both are same types
    case (PureType, RightNodeType) => PureType
    case (RightNodeType, PureType) => PureType
    case _ => this
  }
}

object PureType extends NodeType //A node that is not left child of any node and none of it's ancestors are a left child of any node
object RightNodeType extends NodeType
object LeftNodeType extends NodeType
