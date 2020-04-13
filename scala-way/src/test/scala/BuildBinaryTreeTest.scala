import org.junit.Test
import org.junit.Assert._
import org.junit._
import types.Tree
import types.Tree._
import misc._
import scala.language.implicitConversions

class BuildBinaryTreeTest {
    @Test def testBuildBinaryTree() = {
        val input: Array[Char] = "ABCDEFGHIJ".toCharArray match
            case seq@Array(_*) => seq
            case somethingElse => throw new Exception(s"${somethingElse.getClass} returned")
        val tree: Tree[Char] = buildBinaryTree(input)

        def traverseAndAssert(tree: Tree[Char]): Seq[Char] = tree match
            case Node(_, left: Node[Char], v, right: Node[Char]) => 
                assertTrue(Math.abs(left.height - right.height) <= 1)
                val visitedNodes1: Seq[Char] = traverseAndAssert(left)
                val visitedNodes2: Seq[Char] = traverseAndAssert(right)
                v +: (visitedNodes1 ++ visitedNodes2)
            case Node(_, left, v, right) =>
                val visitedNodes1: Seq[Char] = traverseAndAssert(left)
                val visitedNodes2: Seq[Char] = traverseAndAssert(right)
                v +: (visitedNodes1 ++ visitedNodes2)
            case Leaf() => 
                assertTrue(true)
                Seq()
        val visitedNodes: Seq[Char] = traverseAndAssert(tree)
        assertEquals(10, visitedNodes.size)
        visitedNodes.foreach(n => assertTrue(input.contains(n)))
    }
}