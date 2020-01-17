import org.junit.Test
import org.junit.Assert._
import org.junit._
import greedy.minGroups

class GroupChildrenTest {
    @Test def happyPathTest() = {
        val childrenAges = Array(2, 2.5f, 3, 4)
        val result = minGroups(childrenAges)
        assertTrue(result == 2)
    }

    @Test def noGroupingsPossible() =  {
        val childrenAges = Array(2, 3.5f, 4.6f,6)
        val result = minGroups(childrenAges)
        assertTrue(result == 4)
    }

    @Test def noChildrenGiven() =  {
        val childrenAges = Array[Float]()
        val result = minGroups(childrenAges)
        assertTrue(result == 0)
    }
}
