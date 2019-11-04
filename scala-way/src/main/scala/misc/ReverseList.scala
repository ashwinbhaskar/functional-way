package misc

object ReverseList extends App{

  println(reverse(List(1,2,3,4)))

  def reverse[A](xs: List[A]): List[A] = xs.foldLeft[List[A]](Nil)(insertAtHead)

  def insertAtHead[B](xs: List[B], x: B): List[B] = xs match {
    case Nil => x :: Nil
    case y :: ys => x :: y :: ys
  }

}
