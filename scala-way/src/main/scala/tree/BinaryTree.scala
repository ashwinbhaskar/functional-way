package tree

enum BinaryTree[+A]:
    case Leaf extends BinaryTree[Nothing]
    case Node(left: BinaryTree[A], value: A, right: BinaryTree[A])
