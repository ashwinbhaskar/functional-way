import tree.inverse
import tree.BinaryTree
import tree.BinaryTree._

import org.junit.Test
import org.junit.Assert._
import org.junit._

class InverseBSTTest {
  @Test def fullTreeTest() = {
    val testTree = Node[Int](
      Node(Leaf, 2, Leaf),
      1,
      Node(
        Node(Leaf, 4, Leaf),
        3,
        Node(Leaf, 5, Leaf)
      )
    )

    val expectedTree = inverse(Node(
      Node(
        Node(Leaf, 5, Leaf),
        3,
        Node(Leaf, 4, Leaf)
      ),
      1,
      Node(Leaf, 2, Leaf)
    ))
    assertTrue(inverse(testTree) == expectedTree)
  }

  @Test def emptyTree() = {
    val testTree = inverse(Node(Leaf, 1, Leaf))
    val expectedTree = inverse(Node(Leaf, 1, Leaf))
    assertTrue(inverse(testTree) == expectedTree)
  }

  @Test def symmeticalTree() = {
    val symTree = inverse(Node(
      Node(
        Node(Leaf, 3, Leaf),
        2,
        Node(Leaf, 4, Leaf)
      ),
      1,
      Node(
        Node(Leaf, 3, Leaf),
        2,
        Node(Leaf, 4, Leaf)
      )
    ))
    assertTrue(inverse(symTree) == symTree)
  }
}
