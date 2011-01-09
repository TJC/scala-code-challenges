// http://projecteuler.net/index.php?section=problems&id=14

import Stream.cons

def seqnext(x: Long) = x match {
    case x if x%2 == 0 => x/2
    case x => 3*x + 1
}

def probseq(x: Long) : Stream[Long] = cons(x, x match {
    case 1 => Stream.empty
    case _ => probseq(seqnext(x))
})

// Would be faster if we cached probseq.size rather than recalculated it
// over and over again..

(1 until 1000000).reduceLeft(
    (a,b) => if (probseq(a).size > probseq(b).size) a else b
)

// Alternatively:
(1 until 1000000).sortBy(probseq(_).size).last

