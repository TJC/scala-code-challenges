import scala.io.Source

object WordFinder {

    def main(args: Array[String]) {
        val avail_chars = AWord(args(0))
        println("Freq map: " + avail_chars)

        val wordlist = Source.fromFile("/usr/share/dict/words")

        def word_subset(x: String) = AWord(x) <= avail_chars

        val matches = wordlist.getLines.filter(word_subset).toList
        // toList is needed or else we can only walk the iterator once,
        // but in that case it does seem to do the disk-reading only when we
        // finally need the values out of it, which is neat.

        println("All matches:")
        matches.sortBy( _.length ).foreach(println)

        println("Perfect match:")

        matches.filter(
            word => avail_chars == AWord(word)
        )
        .foreach(println)

    }

}

class AWord(word: String) {
    val Aval = 'a'.getNumericValue
    val letter_freq = new Array[Int](26)
    // defaults to 0 for each item, but if it didn't we would do:
    // (0 to 25).foreach(letter_freq(_) = 0)

    // ignore characters other than a-z, and map upper to lower case
    // then put the counts into the array:
    def only_letters(c: Char) = c >= 'a' && c <= 'z'

    word.toCharArray.map(_.toLower).filter(only_letters)
    .foreach(
        c => letter_freq(c.getNumericValue - Aval) += 1
    )


    // Check to see if there is an exact match between two frequency maps.
    override def equals (o: Any) = o match {
        case x: AWord => x.letter_freq.sameElements(letter_freq)
        case _ => false
    }

    // This worked as well, but I'm told it's bad practice. Better to use
    // the above method which accepts ANY type, not just its own.
    // def == (x: AWord) = x.letter_freq.sameElements(letter_freq)

    // We should do hashCode() as well for best-practice, if we've overridden
    // equals().  ...  I'll just proxy it into the underlying array.
    override def hashCode() = letter_freq.hashCode


    // Compare two words' frequency maps to see if one fits in the other..
    def <= (x: AWord) =
        letter_freq zip x.letter_freq forall { case (a,b) => a <= b }


    // Let us stringify the frequency map for printing:
    override def toString =
        letter_freq.map(_.toString).reduceLeft(_ + "," + _)

}

// Companion object to give us an easier constructor
object AWord {
    def apply(word: String) : AWord = new AWord(word)
}
