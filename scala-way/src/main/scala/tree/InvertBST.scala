package tree

/*
The inverse of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.

Eg :-

    1                  1
   / \                / \
  2   3      =>      3   2
     / \            / \
    4   5          5   4

 */

import scala.math.Ordering
import BinaryTree._

def inverse[A](tree: BinaryTree[A]): BinaryTree[A] =
  tree match
    case Leaf => Leaf
    case Node(left, v, right) => Node(inverse(right), v, inverse(left))
