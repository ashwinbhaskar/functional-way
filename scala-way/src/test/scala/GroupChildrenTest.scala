import org.scalatest.FunSuite
import greedy.GroupChildren

class GroupChildrenTest extends FunSuite {
    test("Should return the correct number of minimum groups") {
        val childrenAges = Array(2, 2.5f, 3, 4)
        val minGroups = GroupChildren.minGroups(childrenAges)
        assert(minGroups == 2)
    }

    test("Should return the number of children as the answer when no groupings are possible") {
        val childrenAges = Array(2, 3.5f, 4.6f,6)
        val minGroups = GroupChildren.minGroups(childrenAges)
        assert(minGroups == 4)
    }

    test("Should return 0 when no children ages are given") {
        val childrenAges = Array[Float]()
        val minGroups = GroupChildren.minGroups(childrenAges)
        assert(minGroups == 0)
    }
}