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

type MaybeNode = Node | Null

case class Node(value: Int, left: MaybeNode, right: MaybeNode)

enum NodeType
  case PureType, RightNodeType, LeftNodeType  //PureType is a node that is not left child of any node and none of it's ancestors are a left child of any node
  def &&(anotherNode: NodeType): NodeType = (this, anotherNode) match
    case (a, b) if a == b => a //both are same types
    case (PureType, RightNodeType) => PureType
    case (RightNodeType, PureType) => PureType
    case _ => this

/**
   @param root The root node of the tree to be transformed.
   @return The root node of the transformed tree
**/
def transformBst(root: Node): Node =
  import NodeType._
  def internalFunc(node: MaybeNode, nodeType: NodeType, parentWeight: Int, origParentValue: Int): MaybeNode = node match
    case n: Node =>
      val transformedValue = nodeType match
        case PureType => sumRightChildren(n)
        case RightNodeType => sumRightChildren(n) + parentWeight
        case LeftNodeType => sumRightChildren(n) + parentWeight + origParentValue
      val rightChild = internalFunc(n.right, nodeType = RightNodeType && nodeType, parentWeight = parentWeight + origParentValue, origParentValue = n.value)
      val leftChild = internalFunc(n.left, nodeType = LeftNodeType && nodeType, parentWeight = transformedValue, origParentValue = n.value)
      Node(transformedValue, left = leftChild, right = rightChild)
    case null => 
      null
  internalFunc(root, nodeType = PureType, parentWeight = 0, origParentValue = 0) match 
    case n: Node => n
    case null => throw Exception("This is not possible") //How can we avoid this code?

private def sumRightChildren(node: Node): Int =
  def internalFunc(a: MaybeNode): Int = a match
    case n: Node => n.value + internalFunc(n.left) + internalFunc(n.right)
    case null => 0
  internalFunc(node.right)

@main def bstTransformer = 
  val root : Node = 
    val leaf1 = Node(1, null, null)
    val leaf2 = Node(6, null, null)
    val leaf3 = Node(8, null, null)
    val interim1 = Node(2, null, null)
    val interim3 = Node(6, null, leaf2)
    val interim2 = Node(7, interim3, leaf3)
    Node(5, interim1, interim2)
  val transformedRoot = transformBst(root)
  println(s"transformed root value = ${transformedRoot.value}")