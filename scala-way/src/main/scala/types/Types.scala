package types

enum Tree[A]
  case Leaf[A]() extends Tree[A]
  case Node[A](height: Int, left: Tree[A], value: A, right: Tree[A]) extends Tree[A]