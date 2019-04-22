package divideandconquer
import util.Implicits._
/*
Given
1) An input string without any space
2) A dictionary of meaningful words

returns
A sentence that can be formed with the given input


 */

object FormSentence extends App{
  val sentenceWithoutSpace = "iamlegend"
  val dictionary : Set[String] = Set("i", "am","legend","and","you")

  val meaningfulList : Option[List[String]]=getMeaningfulSentence(sentenceWithoutSpace)(dictionary)

  meaningfulList match {
    case Some(list) => println(list.mkString(" "))
    case None => println("A meaningful sentence cannot be formed.")
  }


  def getMeaningfulSentence(input : String)(implicit dictionary : Set[String]) : Option[List[String]] = {

    def isWord(word : String) : Boolean = dictionary.contains(word)

    def internalFunc(possibleSentence : String) : Option[List[String]] = possibleSentence.toList match{
      case List() => None
      case a :: List() => if(isWord(a.toString)) Some(List(a.toString)) else None
      case other1 if isWord(other1.mkString("")) => Some(List(other1.mkString("")))
      case other2 => (1 to other2.length).map(l =>{
        if(isWord(other2.take(l))){
          internalFunc(other2.drop(l).mkString("")) match {
            case Some(list) => Some(other2.take(l).mkString("")::list)
            case None => None
          }
        }else None
      }).reduce((a,b) => if(a.isEmpty && b.isEmpty) None else if(a.nonEmpty) a else b)
    }

    internalFunc(input)
  }
}
