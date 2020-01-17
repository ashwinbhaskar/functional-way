package misc

def reverse[A](xs: List[A]): List[A] = xs.foldLeft[List[A]](Nil)(insertAtHead)

private def insertAtHead[B](xs: List[B], x: B): List[B] = xs match
  case Nil => x :: Nil
  case y :: ys => x :: y :: ys

@main def listReverser = 
  println(reverse(List(1,2,3,4)))
