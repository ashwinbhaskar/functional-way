import tree.{ invert, InvertNode }

import org.junit.Test
import org.junit.Assert._
import org.junit._

class InvertBSTTest {
  @Test def fullTreeTest() = {
    val testTree = InvertNode(
      1,
      Some(InvertNode(2)),
      Some(InvertNode(
        3,
        Some(InvertNode(4)),
        Some(InvertNode(5))
      ))
    )

    val expectedTree = InvertNode(
      1,
      Some(InvertNode(
        3,
        Some(InvertNode(5)),
        Some(InvertNode(4))
      )),
      Some(InvertNode(2))
    )
    assertTrue(invert(testTree) == expectedTree)
  }

  @Test def emptyTree() = {
    val testTree = InvertNode(1)
    val expectedTree = InvertNode(1)
    assertTrue(invert(testTree) == expectedTree)
  }

  @Test def symmeticalTree() = {
    val symTree = InvertNode(
      1,
      Some(InvertNode(
        2,
        Some(InvertNode(3)),
        Some(InvertNode(4))
      )),
      Some(InvertNode(
        2,
        Some(InvertNode(4)),
        Some(InvertNode(3))
      ))
    )
    assertTrue(invert(symTree) == symTree)
  }
}
