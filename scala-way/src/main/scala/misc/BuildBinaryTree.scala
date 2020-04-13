package misc

import types.Tree._
import types.Tree

private def add[A](elem: A, tree: Tree[A]): Tree[A] =
    tree match
      case node@Node(height, Leaf(), value, _) => node.copy(height = 1, left = Node(0, Leaf(), elem, Leaf()))
      case node@Node(height, left, value, Leaf()) => node.copy(height = 1, right = Node(0, Leaf(), elem, Leaf()))
      case node@Node(height, left: Node[A], value, right: Node[A]) => 
        if(left.height > right.height) 
          val newNode = add(elem, node.right).asInstanceOf[Node[A]]
          node.copy(height = newNode.height + 1, right = newNode)
        else
          val newNode = add(elem, node.left).asInstanceOf[Node[A]]
          node.copy(height = newNode.height + 1, left = newNode)
      case Leaf() => Node(0, Leaf(), elem, Leaf())
    
def buildBinaryTree[A](elems: Seq[A]): Tree[A] =
    elems.foldRight(z = Leaf())(op = add)
