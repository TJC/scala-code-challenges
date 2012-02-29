/*
Challenge posed by Tony Morris:

http://en.wikipedia.org/wiki/Happy_number
def isHappy(n: Int): Boolean
Do not use variables.

*/

def square_digits(n: Int): Int =
    n.toString.toCharArray.map(_.toString.toInt).map(m => m*m).sum

def isHappy(n: Int): Boolean = {

    def inner(m: Int, seen: Set[Int]): Boolean =
        m match {
            case 1 => true
            case m if (m < 100 && seen.contains(m)) => false
            case _ => inner(square_digits(m), seen + m)
        }

    inner(n, Set[Int]())
}

// vim: set ts=4 sw=4 et:
