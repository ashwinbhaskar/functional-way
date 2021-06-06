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

enum NodeType:
  case PureType, RightNodeType, LeftNodeType  //PureType is a node that is not left child of any node and none of it's ancestors are a left child of any node
  def &&(anotherNode: NodeType): NodeType = (this, anotherNode) match
    case (a, b) if a == b => a //both are same types
    case (PureType, RightNodeType) => PureType
    case (RightNodeType, PureType) => PureType
    case _ => this

import scala.math.Ordering
import BinaryTree._

/**
   @param root The root node of the tree to be transformed.
   @return The root node of the transformed tree
**/
def transformBst(root: BinaryTree[Int]): BinaryTree[Int] =
  import NodeType._
  def internalFunc(node: BinaryTree[Int], nodeType: NodeType, parentWeight: Int, origParentValue: Int): BinaryTree[Int] = node match
    case n@Node(left, value, right) =>
      val transformedValue = nodeType match
        case PureType => sumRightChildren(n)
        case RightNodeType => sumRightChildren(n) + parentWeight
        case LeftNodeType => sumRightChildren(n) + parentWeight + origParentValue
      val rightChild = internalFunc(right, nodeType = RightNodeType && nodeType, parentWeight = parentWeight + origParentValue, origParentValue = value)
      val leftChild = internalFunc(left, nodeType = LeftNodeType && nodeType, parentWeight = transformedValue, origParentValue = value)
      Node(leftChild, transformedValue, rightChild)
    case Leaf => Leaf
  internalFunc(root, nodeType = PureType, parentWeight = 0, origParentValue = 0) match 
    case n@Node(_, _, _) => n
    case Leaf => throw Exception("This is not possible") //How can we avoid this code?

private def sumRightChildren(node: BinaryTree[Int]): Int =
  def internalFunc(a: BinaryTree[Int]): Int = a match
    case Node(left, value, right) => value + internalFunc(left) + internalFunc(right)
    case Leaf => 0

  node match
    case Leaf => 0
    case Node(_, _, right) => internalFunc(right)

@main def bstTransformer = 
  val root : BinaryTree[Int] = 
    val leaf1 = Node(Leaf, 1, Leaf)
    val leaf2 = Node(Leaf, 6, Leaf)
    val leaf3 = Node(Leaf, 8, Leaf)
    val interim1 = Node(Leaf, 2, Leaf)
    val interim3 = Node(Leaf, 6, leaf2)
    val interim2 = Node(interim3, 7, leaf3)
    Node(interim1, 5, interim2)
  transformBst(root) match
    case Leaf => println(s"transformed root is a leaf")
    case Node(_, value, _) => println(s"transformed root value = $value")