/*
Challenge posed by Tony Morris:

http://en.wikipedia.org/wiki/Happy_number
def isHappy(n: Int): Boolean
Do not use variables.

*/

import scala.collection.mutable

def square_digits(n: Int): Int =
    n.toString.toCharArray.map(_.toString.toInt).map(m => m*m).sum


def isHappy(n: Int): Boolean = {

    val seen_map :mutable.Map[Int,Boolean] = mutable.Map()

    def have_seen(m: Int): Boolean = {
        if (seen_map contains m) return true
        seen_map(m) = true
        false
    }

    def internal_isHappy(m: Int): Boolean = {
        println(m)
        m match {
            case 1 => true
            case m if (m < 100 && have_seen(m)) => false
            case _ => internal_isHappy(square_digits(m))
        }
    }

    internal_isHappy(n)
}

// vim: set ts=4 sw=4 et:
