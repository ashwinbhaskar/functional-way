package types

enum Tree[A]:
  case Leaf[A]() extends Tree[A]
  case Node[A](height: Int, left: Tree[A], value: A, right: Tree[A]) extends Tree[A]
  
opaque type Peg = String
object Peg:
  def apply(string: String): Peg = string

opaque type Move = (Peg, Peg)
object Move:
  def apply(fromPeg: Peg, toPeg: Peg): Move = (fromPeg, toPeg)