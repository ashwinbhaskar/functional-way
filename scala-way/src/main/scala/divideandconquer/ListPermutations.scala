package divideandconquer

/*
Example List[Int](1,2,3) should return
List(List(1, 2, 3), List(2, 1, 3), List(2, 3, 1), List(1, 3, 2), List(3, 1, 2), List(3, 2, 1))
 */

/*
   Permutation of a list `x cons xs` [x is the head and xs is the tail]
   is nothing but inserting x into all the possible positions of
   Permutations of xs
   */
def permutations(list: List[Int]): List[List[Int]] = list match
  case Nil => Nil
  case x :: Nil => List(List(x))
  case x :: xs =>
    for {
      permutation <- permutations(xs)
      i <- 0 to xs.length
    } yield
        permutation.take(i) ++ List(x) ++ permutation.drop(i)

@main def listPermutations = 
  println(permutations(List(1, 2, 3)))
