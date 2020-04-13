import org.junit.Test
import org.junit.Assert._
import org.junit._
import divideandconquer.towerOfHanoi
import types.{Move, Peg}

class TowerOfHanoiTest {
    @Test
    def testAlgorithmCorrectNess1() = {
        val (pegA, pegB, pegC) = (Peg("pegA"), Peg("pegB"), Peg("pegC"))
        val expectedResult = List(Move(pegA, pegC), Move(pegA, pegB), Move(pegC, pegB))
        val numberOfDiscs = 2
        val actualResult = towerOfHanoi(numberOfDiscs, pegA, pegB, pegC)
        assertEquals(expectedResult, actualResult)
    }
    @Test
    def testAlgorithmCorrectNess2() = {
        val (pegA, pegB, pegC) = (Peg("pegA"), Peg("pegB"), Peg("pegC"))
        val expectedResult = List(Move(pegA, pegB), Move(pegA, pegC), Move(pegB, pegC), 
                                    Move(pegA, pegB), Move(pegC, pegA), Move(pegC, pegB), Move(pegA, pegB))
        val numberOfDiscs = 3
        val actualResult = towerOfHanoi(numberOfDiscs, pegA, pegB, pegC)
        assertEquals(expectedResult, actualResult)
    }
    @Test
    def testAlgorithmCorrectNess3() = {
        val (pegA, pegB, pegC) = (Peg("pegA"), Peg("pegB"), Peg("pegC"))
        val expectedResult = List()
        val numberOfDiscs = 0
        val actualResult = towerOfHanoi(numberOfDiscs, pegA, pegB, pegC)
        assertEquals(expectedResult, actualResult)
    }
}