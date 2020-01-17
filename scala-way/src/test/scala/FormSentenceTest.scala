import org.junit.Test
import org.junit.Assert._
import org.junit._
import divideandconquer._

class FormSentenceTest {
    @Test def happyPath() = {
        val sentenceWithoutSpace = "iamlegend"  
        val dictionary : Set[String] = Set("i", "am","legend","and","you")
        val meaningfulList : Option[List[String]] = getMeaningfulSentence(sentenceWithoutSpace)(dictionary)
        assertTrue(meaningfulList == Some(List("i", "am", "legend")))
    }
}