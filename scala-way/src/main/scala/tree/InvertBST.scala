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

final case class InvertNode(
  value: Int,
  left: Option[InvertNode] = None,
  right: Option[InvertNode] = None
)

def invert(n: InvertNode): InvertNode =
  InvertNode(n.value, n.right.map(invert), n.left.map(invert))
